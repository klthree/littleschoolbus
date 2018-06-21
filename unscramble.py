#!/usr/bin/python -u
import random,string

flag = "BNZQ:1l36de9583w5516fv3b8691102224f3e"

random.seed("random")

flagSolved = ""

for c in flag:
    if c.islower():
        flagSolved += chr((ord(c) - ord('a') - random.randrange(0, 26)) % 26 +
        ord('a'))
    elif c.isupper():
        flagSolved += chr((ord(c) - ord('A') - random.randrange(0, 26)) % 26 +
        ord('A'))
    elif c.isdigit():
        flagSolved += chr((ord(c) - ord('0') - random.randrange(0, 10)) % 10 +
        ord('0'))
    else:
        flagSolved += c

print flagSolved

