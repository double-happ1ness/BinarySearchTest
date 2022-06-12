// this is a cut down version of the class specifically for the Binary Search test
// the complete version is in the Library folder on Moodle

public class SortedArray implements SortedADT {

    private Comparable[] objects;
    private Integer objectCount;

    public SortedArray(Integer arraySize) {
        this.objects = new Comparable[arraySize];
        this.objectCount = 0;
    }

    public String toString() {
        String arrayDetails = new String();
        if (this.objectCount != 0) {
            for (Integer index = 0; index < this.objectCount; index++) {
                arrayDetails += objects[index] + "\n";
            }
        } else {
            arrayDetails += "array is empty";
        }
        return arrayDetails;
    }

    public void insert(Comparable object) {
        // cut down version, for this test objects are added in order
        this.objects[this.objectCount] = object;
        this.objectCount++;
    }

    public Comparable find(Comparable object) throws NotFoundException {
        /* algorithm
            if array empty then
                throw not found exception
            end if
            while object not found loop
                set current position to the midpoint of the array
                if object matches object at the current position then
                    object found
                else
                    if object is less than object at current position then
                        set the end point to the point immediately before the current position
                    else
                        set the start point to the point immediately after the current position
                    end if
                    if no more objects to check then
                        throw not found exception
                    end if
                end if
            end loop
         */
        // only start check if array is occupied
        if (this.objectCount == 0) {
            throw new NotFoundException();
        }
        Comparable foundObject = null;
        Integer startPosition = 0;
        Integer endPosition = this.objectCount - 1;
        Integer midPosition;
        // add code here
//        Integer currentPosition;
        Boolean objectFound = false;
        while (!objectFound) {
            midPosition = ((startPosition + endPosition) / 2);
            if (object.compareTo(this.objects[midPosition]) == 0) {
                objectFound = true;
            } else if (object.compareTo(this.objects[midPosition]) < 0) {
                endPosition = midPosition - 1;
            } else {
                startPosition = midPosition + 1;
            }
            if (startPosition > endPosition) {
                throw new NotFoundException();
            }
        }

        return foundObject;
    }
}
