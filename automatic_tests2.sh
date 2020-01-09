#!bin/bash
#patrycja

ARGS=$1

for ((i = 3; i <= $ARGS; i ++))
do
  for value in {0..4}
  do
	  java -jar ./target/ox-1.0.0.jar $i $2 $value $4 $5
	  cp src/main/resources/pl/patrycja/ox/ui/test_out.txt src/main/resources/pl/patrycja/ox/ui/automatics_size$i-case$2-toward$value-$4-$5.txt
	done
done
