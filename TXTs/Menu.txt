echo Menu Driven Program
op=0
while [ $op -ne 4 ]
do
	printf "\n1 - List of all users\n"
	echo 2 - Present working directory
	echo "3 - View file"
	echo 4 - Exit
	echo Select option
	read op
	case $op in
		1) who ;;
		2) pwd ;;
		3) echo Enter filename
		read filename
		   cat $filename ;;
		4) echo Exit ;;
		*) echo Invalid Option ;;
	esac
done
