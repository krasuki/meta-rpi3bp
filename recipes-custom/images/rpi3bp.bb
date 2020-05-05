SUMMARY = "Custom Yocto image for Raspberry Pi 3B+"
LICENSE = "GPL-3.0"

inherit core-image

IMAGE_FEATURES += "splash"
IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL_append = " mc"
IMAGE_INSTALL_append = " nano"
