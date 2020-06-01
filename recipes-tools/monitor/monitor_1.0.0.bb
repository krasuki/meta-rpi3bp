SUMMARY = "Monitoring Qt5 application"
DESCRIPTION = " The application displays general information about the target, monitoring graph (cpu and ram) and network information."
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit qmake5
require recipes-qt/qt5/qt5.inc

DEPENDS += "qtbase qtquickcontrols2 qtdeclarative"

SRC_URI = "git://git@github.com/krasuki/rpi-monitoring.git;protocol=ssh;nobranch=1;tag=v${PV}"

S = "${WORKDIR}/git"

do_install_append() {
    install -d ${D}${bindir}
    install -m 0755 rpi-monitoring ${D}${bindir}
}

