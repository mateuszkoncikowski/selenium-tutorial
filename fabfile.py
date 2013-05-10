__author__ = 'mateusz'

from fabric.api import *


def clean_workspace():
    print "Clearing workspace"
    local("rm -rf *")
    print "Clearing workspace has been finished"


def clean_database():
    print "Clearing database"
    local("mysql -uroot forum < src/main/resources/forum/db.sql")
    print "Clearing database has been finished"


def build_release_package():
    print "Building release package"
    local("zip -rj release_package.zip  src/main/resources/*")
    print "Building release package has been finished"