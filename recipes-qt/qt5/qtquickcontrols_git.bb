require qt5.inc
require qt5-git.inc

LICENSE = "GFDL-1.3 & BSD-3-Clause & LGPL-3.0-only | GPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=e0459b45c5c4840b353141a8bbed91f0 \
    file://LICENSE.GPLv2;md5=c96076271561b0e3785dad260634eaa8 \
    file://LICENSE.GPLv3;md5=88e2b9117e6be406b5ed6ee4ca99a705 \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtdeclarative"

RDEPENDS:${PN}-dev = ""

# Patches from https://github.com/meta-qt5/qtquickcontrols/commits/b5.6
# 5.6.meta-qt5.1
SRC_URI += " \
    file://0001-texteditor-fix-invalid-use-of-incomplete-type-class-.patch \
"

SRCREV = "b66f6b05c5f8024ddd9f8c46f33ccb618323999e"
