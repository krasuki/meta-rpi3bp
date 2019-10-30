#!/bin/bash

build_repo()
{
    if [ ! -d ".repo" ] 
	then
        echo "### setup repo environment ### "
        export REPO_URL=git@titanus:PR/Yocto/git-repo.git
        repo init -u git@github.com:krasuki/meta-rpi3bp/manifest.git -b develop
    fi

    echo "### sync repo environment ### "
    repo sync
}

build_image()
{
    if [ ! -d "build" ]
    then
        echo "### setup build environment ### "

		#création de l'environnement pour Yocto à partir du conf du firmware et du meta top
		rm -rf conf
		mkdir -p conf
		pwd
        cp ./sources/${NAME_TOP_META}/conf/local.conf.sample ./conf
		cp ./../conf/* ./conf
		export TEMPLATECONF=../conf
        source sources/poky/oe-init-build-env
    else
        source sources/poky/oe-init-build-env
    fi


    # echo "### clean sstate: sdt-pr3334 ### "
    bitbake sdt-pr3334 -c cleansstate
	# echo "### clean sstate: ctp-tools ### "
    bitbake ctp-tools -c cleansstate
	# echo "### clean sstate: kvision-tools ### "
    bitbake kvision-tools -c cleansstate
	# echo "### clean sstate:  ### "
    bitbake ${IMAGE_TO_GENERATE} -c cleansstate

    # echo "### generate file ### "
	bitbake ${IMAGE_TO_GENERATE}
}


mkdir -p tmp_yocto
cd tmp_yocto || exit 1
build_repo && build_image
