require qt5.inc
require qt5-git.inc

# There are no LGPLv3-only licensed files in this component.
# There are no GPLv2 licensed files in this component.
LICENSE = "GFDL-1.3 & BSD-3-Clause & (LGPL-2.1-only | LGPL-3.0-only)"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPLv2;md5=05832301944453ec79e40ba3c3cfceec \
    file://LICENSE.LGPLv21;md5=58a180e1cf84c756c29f782b3a485c29 \
    file://LICENSE.LGPLv3;md5=b8c75190712063cde04e1f41b6fdad98 \
    file://LICENSE.GPLv3;md5=40f9bf30e783ddc201497165dfb32afb \
    file://examples/webkitwidgets/scroller/wheel/main.cpp;endline=39;md5=b0739af76072fbe303dc04b6941e054f \
    file://examples/webkitwidgets/imageanalyzer/imageanalyzer.cpp;endline=39;md5=b0739af76072fbe303dc04b6941e054f \
"

PACKAGECONFIG ?= "examples"

DEPENDS += "qtwebkit qtxmlpatterns"
RDEPENDS:${PN}-examples += "qtwebkit-qmlplugins"
RDEPENDS:${PN}-examples += "${@bb.utils.contains('PACKAGECONFIG_OPENSSL', 'openssl', 'ca-certificates', '', d)}"

SRCREV = "0c623fab420102c54fa533da3b8ca774290d6d13"
