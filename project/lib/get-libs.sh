DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";


wget --output-document=$DIR/junit-4.10.jar search.maven.org/remotecontent?filepath=junit/junit/4.10/junit-4.10.jar;

if [ "$?" != 0 ]
then
	echo "Cannot download a file!\n";
	return 1;
fi