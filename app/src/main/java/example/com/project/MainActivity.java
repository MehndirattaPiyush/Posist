package example.com.project;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int nodeNum = 0;
    public static String genesisNodeRef = null ;
    public ArrayList<Node> nodes = new ArrayList<>();

    EditText parEt;
    EditText valEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parEt = findViewById(R.id.et_par);
        valEt = findViewById(R.id.child_val);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Node node = new Node("100",genesisNodeRef);
                Toast.makeText(getApplicationContext(),"Genisis node created with data :"+node.data +" and node number is "+node.nodeNumber,Toast.LENGTH_LONG).show();
                nodes.add(node);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.add_child :
                addIfPossible(parEt.getText().toString() , valEt.getText().toString() );
                break;
            case R.id.encrypt :

                break;
            case R.id.decrypt :

                break;

        }
    }
    public void addIfPossible(String nodeNumber , String data){
        if(Integer.parseInt(nodes.get(Integer.parseInt(nodeNumber)).data) - getSumChild(nodes.get(Integer.parseInt(nodeNumber))) > Integer.parseInt(data)){
            Node node = new Node(data , nodeNumber);
            if(nodes.get(Integer.parseInt(nodeNumber)).right==null)
                nodes.get(Integer.parseInt(nodeNumber)).right = node;
            if(nodes.get(Integer.parseInt(nodeNumber)).left!=null)
                nodes.get(Integer.parseInt(nodeNumber)).left = node;
            Toast.makeText(getApplicationContext(),"new node created",Toast.LENGTH_LONG);
        } else {
            Toast.makeText(getApplicationContext(),"noo new node created",Toast.LENGTH_LONG);
        }
    }
    public int getSumChild(Node node){
        int sum = 0;
        if(node.left == null && node.right == null)
            return 0;
        if(node.right!=null)
            sum = sum+Integer.parseInt(node.right.data);
        if(node.left!=null)
            sum = sum + Integer.parseInt(node.left.data);

        return sum;
    }
}
