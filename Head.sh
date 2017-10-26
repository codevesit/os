echo Enter filename
read filename
echo Enter number of lines
read lines
i=0
terminal='tty'
exec < $filename
while [ $i -lt $lines ]
do
	read line
	echo $line
	i=`expr $i + 1`
done
exec > $terminal
