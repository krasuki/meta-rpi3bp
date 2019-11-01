#!/bin/bash

IMAGE_TO_GENERATE="core-image-base"

build_repo()
{
    if [ ! -d ".repo" ] 
	then
        echo "### setup repo environment ### "
        repo init -u git@github.com:krasuki/meta-rpi3bp.git -b develop
    fi

    echo "### sync repo environment ### "
    repo sync
}

build_image()
{
    if [ ! -d "build" ]
    then
        echo "### setup build environment ### "

		cp ./../conf/* ./conf
        source sources/poky/oe-init-build-env
    fi

	# echo "### clean sstate:  ### "
    bitbake ${IMAGE_TO_GENERATE} -c cleansstate

    # echo "### generate file ### "
	bitbake ${IMAGE_TO_GENERATE}
}


mkdir -p tmp_yocto
cd tmp_yocto || exit 1
build_repo && build_image
