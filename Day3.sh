egrep -E -o "mul\([^()]*,[^()]*\)|do\(\)|don\'t\(\)" Day3Input.txt > Day3.txt
sed 's/^/sum += /; s/$/;/' Day3.txt > Day3Lines.txt