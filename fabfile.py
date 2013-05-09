__author__ = 'mateusz'

from fabric.api import *


def clean_database():
    print "Clearing database"
    mysql = "/Applications/XAMPP/xamppfiles/bin/mysql"
    database_scheme = "src/main/resources/forum/db.sql"
    local("%s -uroot forum < %s" % (mysql, database_scheme))
    print "Clearing database finished"
