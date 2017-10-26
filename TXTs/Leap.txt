echo Enter a year
read year
if [ `expr $year % 400` -eq 0 ]
then
	echo Entered year is a leap year.
elif [ `expr $year % 100` -eq 0 ]
then
	echo Entered year is not a leap year.
elif [ `expr $year % 4` -eq 0 ]
then
	echo Entered year is a leap year.
else
	echo Entered year is not a leap year.
fi
