package ctci.linkedlists;

class Partition {

    void split(Node list, final int key) {
        Node index = list;
        Node partition1 = null;
        Node partition2 = null;

        while (index != null) {

            if (index.data < key) {
                partition1 = addToPartition(index, partition1);
            } else {
                partition2 = addToPartition(index, partition2);
            }

            index = index.next;
        }
        partition1.appendToTail(partition2);

        replace(list, partition1);
    }

    private void replace(Node list, Node partition) {
        while(list != null) {
            list.data = partition.data;
            list = list.next;
            partition = partition.next;
        }
    }

    private Node addToPartition(Node index, Node partition) {
        if (partition == null ){
            partition = new Node(index.data);
        } else {
            partition.appendToTail(new Node(index.data));
        }
        return partition;
    }
}
