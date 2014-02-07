#!/bin/bash
list="builder adapter bridge filter facade proxy command iterator observer mvc dao servicelocator tfo"
for l in $list; do
	mkdir src/main/java/$l
	mkdir src/test/java/$l
done
