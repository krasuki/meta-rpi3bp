SUMMARY = "Custom Yocto image for Raspberry Pi 3B+ with Qt5"
LICENSE = "GPL-3.0"

require recipes-custom/images/rpi3bp.bb

inherit populate_sdk_qt5
inherit qmake5

IMAGE_INSTALL_append = " \
	qt3d \
	qt3d-tools \
	qt5-opengles2-test \
	qtbase \
	qtbase-plugins \
	qtbase-tools \
	qtdeclarative \
	qtdeclarative-plugins \
	qtdeclarative-tools \
	qtdeclarative-qmlplugins \
	qtimageformats-plugins \
	qtmultimedia \
	qtmultimedia-plugins \
	qtquickcontrols \
	qtquickcontrols2 \
	qtsystems \
	qtsystems-tools \
	qttools \
	"

