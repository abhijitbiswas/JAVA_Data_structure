package Algo.List;

/**
 * Abhijit.Biswas
 */
class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        this.iData = id;
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "}");
    }

    public class LinkListCustom {
        private Link first;

        public LinkListCustom() {

            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insertFirst(int id, double dd) {

            Link newLink = new Link(id, dd);
            newLink.next = first;
            first = newLink;
        }

        public Link deleteFirst() {
            Link temp = first;
            first = first.next;
            return temp;
        }

        // iterating linked list

        public void displayList() {
            System.out.print("List (first-->last): ");
            Link current = first; // start at beginning of list
            while (current != null) // until end of list,
            {
                current.displayLink(); // print data
                current = current.next; // move to next link
            }
            System.out.println("");
        }

        // searching in linkedlist

        public Link find(int key) // find link with given key
        { // (assumes non-empty list)
            Link current = first; // start at ‘first’
            while (current.iData != key) // while no match,
            {
                if (current.next == null) // if end of list,
                    return null; // didn’t find it
                else
                    // not end of list,
                    current = current.next; // go to next link
            }
            return current; // found it
        }

        // deleate which want

        public Link delete(int key) // delete link with given key
        { // (assumes non-empty list)
            Link current = first; // search for link
            Link previous = first;
            while (current.iData != key) {
                if (current.next == null)
                    return null; // didn’t find it
                else {
                    previous = current; // go to next link

                    current = current.next;
                }
            } //
            if (current == first) // if first link,
                first = first.next; // change first
            else
                // otherwise,
                previous.next = current.next; // bypass it
            return current;
        }

    }


}


