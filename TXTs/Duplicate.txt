echo Enter filename 1 :
read f1
echo Enter filename 2 :
read f2
cmp $f1 $f2
if [ $? -eq 0 ]
then
	echo Contents of $f1 and $f2 are same.
	echo Deleting $f1.
	rm $f1
else
	echo Contents of $f1 and $f2 are not same.
	echo Cannot Delete File.
fi