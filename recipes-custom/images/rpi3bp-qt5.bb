SUMMARY = "Custom Yocto image for Raspberry Pi 3B+ with Qt5"
LICENSE = "GPL-3.0"

require recipes-custom/images/rpi3bp.bb

inherit populate_sdk_qt5
inherit qmake5


MY_PKGS = " \
    qt3d \
    qt3d-dev \
    qt3d-mkspecs \
 	qt3d-tools \
    qt5-opengles2-test \
    qtbase \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-tools \
    qtcharts \
    qtcharts-dev \
    qtcharts-mkspecs \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtquickcontrols2 \
    qtquickcontrols2-dev \
    qtquickcontrols2-mkspecs \
    qtdeclarative \
    qtdeclarative-dev \
	qtdeclarative-qmlplugins \
    qtdeclarative-mkspecs \
	qtdeclarative-plugins \
	qtdeclarative-tools \
    qtgraphicaleffects \
    qtgraphicaleffects-dev \
	qtimageformats-plugins \
	qtmultimedia \
	qtquickcontrols \
	qtsystems \
	qtsystems-tools \
	qttools \
	"

IMAGE_INSTALL_append = " \
    ${MY_PKGS} \
	"