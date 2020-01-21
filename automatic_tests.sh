#!bin/bash
#patrycja

ARGS=$1

for ((i = 3; i <= $ARGS; i ++))

  do
	  java -jar ./target/ox-1.0.0.jar $i $2 $3 $4 $5
	  cp src/main/resources/pl/patrycja/ox/ui/test_out.txt src/main/resources/pl/patrycja/ox/ui/automatics_size$i-case$2-toward$3-$4-$5.txt
	  diff src/main/resources/pl/patrycja/ox/ui/test_out.txt src/main/resources/pl/patrycja/ox/ui/automatics_size$i-case$2-toward$3-$4-$5.txt > src/main/resources/pl/patrycja/ox/ui/automatics_size_diff$i-case$2-toward$3-$4-$5.txt
done