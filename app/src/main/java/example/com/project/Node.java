package example.com.project;

import java.sql.Timestamp;


public class Node
{
    Timestamp timestamp ;
    String data;
    int nodeNumber;
    String nodeId;
    String referenceNodeId;
    String childReferenceNodeIdLeft;
    String childReferenceNodeIdRight;
    String genesisReferenceNodeId;
    String hashValues;
    Node right , left;

    public Node(String  data, String referenceNodeId)
    {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.nodeNumber = MainActivity.nodeNum++;
        if(MainActivity.genesisNodeRef == null){
            this.genesisReferenceNodeId = "iski khud ki id";
            MainActivity.genesisNodeRef = "iski khud ki id";
        }else {
            this.genesisReferenceNodeId = MainActivity.genesisNodeRef;
        }
        this.data = data;
        this.referenceNodeId = referenceNodeId;
        this.hashValues = referenceNodeId+timestamp+data+nodeNumber+referenceNodeId;
        right = left = null;
    }
}
