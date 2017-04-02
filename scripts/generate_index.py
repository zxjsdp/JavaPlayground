#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""根据类自动生成 README 中的 Index."""

from __future__ import print_function

import re
import os
import sys

PROJECT_PATH = '/Users/jin/Work/Eleme/GitLab/playground/'
README_FILE_PATH = PROJECT_PATH + 'README.md'
PLAYGROUND_PATH = PROJECT_PATH + 'src/main/java/com/moflying/playground/'
GITHUB_PREFIX = 'https://github.com/zxjsdp/JavaPlayground/blob/master/src/main/java/com/moflying/playground/'

PLAYGROUND_CLASS_SUFFIX = 'Playground.java'

INDEX_CONTENT_RE = re.compile(r'^(.+)\n((?:\n.+)+)', re.MULTILINE)


def extract_old_index_content(readme_content):
    return re.findall(INDEX_CONTENT_RE, readme_content)


def get_playground_files():
    return [x for x in os.listdir(PLAYGROUND_PATH)
            if x.endswith(PLAYGROUND_CLASS_SUFFIX)]


def get_new_index_content(playground_files):
    lines = ['- [%s](%s%s)' % (x.split('.')[0], GITHUB_PREFIX, x)
             for x in playground_files]
    return '\n' + '\n'.join(lines)


def fatal(message):
    sys.exit('ERROR! ' + message)


def generate_index():
    with open(README_FILE_PATH, 'r') as f:
        content = f.read()

    original_index = extract_old_index_content(content)
    if len(original_index) < 2:
        fatal('Cannot find old "Index" content!')
    if len(original_index[1]) != 2:
        fatal('Cannot find old "Index" content!')
    if original_index[1][0] != '## Index' or\
            not GITHUB_PREFIX in original_index[1][1]:
        fatal('Cannot find old "## Index" content!')

    original_index_content = original_index[1][1]

    playground_files = get_playground_files()
    new_index_content = get_new_index_content(playground_files)

    print("Old index:\n" + original_index_content + '\n\n')
    print("New index:\n" + new_index_content)


def main():
    generate_index()


if __name__ == '__main__':
    main()
