__author__ = 'mateusz'

from fabric.api import *


def clean_database():
    print "Clearing database"
    local("mysql -uroot forum < src/main/resources/forum/db.sql")
    print "Clearing database has been finished"
