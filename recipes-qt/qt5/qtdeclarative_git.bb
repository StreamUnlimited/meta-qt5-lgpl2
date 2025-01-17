require qt5.inc
require qt5-git.inc

# There are no LGPLv3-only licensed files in this component.
LICENSE = "GFDL-1.3 & BSD-3-Clause & (LGPL-2.1-only & The-Qt-Company-Qt-LGPL-Exception-1.1 | LGPL-3.0-only)"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv21;md5=4bfd28363f541b10d9f024181b8df516 \
    file://LICENSE.LGPLv3;md5=e0459b45c5c4840b353141a8bbed91f0 \
    file://LICENSE.GPLv3;md5=88e2b9117e6be406b5ed6ee4ca99a705 \
    file://LGPL_EXCEPTION.txt;md5=9625233da42f9e0ce9d63651a9d97654 \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtbase"

# Patches from https://github.com/meta-qt5/qtdeclarative/commits/b5.6
# 5.6.meta-qt5.7
SRC_URI += " \
    file://0001-qmltestexample-fix-link.patch \
    file://0002-qquickviewcomparison-fix-QCoreApplication-has-not-be.patch \
"

EXTRA_OEMAKE += "QMAKE_SYNCQT=${STAGING_BINDIR_NATIVE}${QT_DIR_NAME}/syncqt"

PACKAGECONFIG ??= "qtxmlpatterns"
PACKAGECONFIG[qtxmlpatterns] = ",,qtxmlpatterns"

do_configure:prepend() {
    # disable qtxmlpatterns test if it isn't enabled by PACKAGECONFIG
    sed -e 's/^\(qtHaveModule(xmlpatterns)\)/OE_QTXMLPATTERNS_ENABLED:\1/' -i ${S}/src/imports/imports.pro
    sed -e 's/^\(!qtHaveModule(xmlpatterns)\)/!OE_QTXMLPATTERNS_ENABLED|\1/' -i ${S}/tests/auto/quick/quick.pro

    #set the path for syncqt properly
    echo "QT_TOOL.syncqt.binary = \"${STAGING_BINDIR_NATIVE}${QT_DIR_NAME}/syncqt\"" > ${B}/.qmake.cache
}

EXTRA_QMAKEVARS_PRE += "${@bb.utils.contains('PACKAGECONFIG', 'qtxmlpatterns', 'CONFIG+=OE_QTXMLPATTERNS_ENABLED', '', d)}"

SRCREV = "bb01612a8809efd268903e41b9e3a17cff48f1c0"

BBCLASSEXTEND =+ "native nativesdk"
