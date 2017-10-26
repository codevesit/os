count=0
for files in $*
do
	count=`expr $count + 1`
done
if [ `expr $count % 2` -eq 0 ]
then
	echo "No. of files entered :" $count
	set $*
	ctr=1
	while [ $ctr -le $count ]
	do
	cp $1 $2
	shift 2
	ctr=`expr $ctr + 2`
	done
	echo Copying Successfull
else
	echo "Error : Odd files Supplied !"
fi
