SUMMARY = "Custom Yocto image for Raspberry Pi 3B+"
LICENSE = "GPL-3.0"

inherit core-image

IMAFE_INSTALL_append = " \
    ssh-server-openssh \
    mc \
    nano \
    splash \
    "


# add conf for rpi3bp wifi and bluetooth
MY_FEATURES = " \
    linux-firmware-bcm43430 \
    bluez5 \
    i2c-tools \
    python-smbus \
    bridge-utils \
    hostapd \
    dhcp-server \
    iptables \
    wpa-supplicant \
	"

IMAGE_INSTALL_append = " \
    ${MY_FEATURES} \
	"

DISTRO_FEATURES_append += " \
    bluetooth \    
    bluez5 \
    wifi \
    "
