package baekjoon23309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

    public static void main(String []args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        s = bf.readLine();
        st = new StringTokenizer(s);
        
        Node[] map = new Node[1000001];
        
        Node root = new Node(0);
        Node curr = root;
        for( int i = 0; i < n; i++ ){
            int station = Integer.parseInt(st.nextToken());
            Node temp = curr;
            curr.next = new Node(station);
            curr = curr.next;
            curr.next = root.next;
            curr.prev = temp;
            map[station] = curr;
        }
        Node first = root;
        first= first.next;
        first.prev = curr;
        
        for( int i = 0; i < m; i++ ){
            s = bf.readLine();
            st = new StringTokenizer(s);
            String method = st.nextToken();
            int _i = Integer.parseInt(st.nextToken());
            int j = -1;
            Node node = map[_i];
            if( method.equals("BN") ){
                j = Integer.parseInt(st.nextToken());
                bw.write( node.next.val +"\n"  ); 
                Node bn_next = node.next;
                node.next = new Node(j);
                node.next.next = bn_next;
                node.next.prev = node;
                bn_next.prev = node.next;
                map[j] = node.next;
            } else if( method.equals("BP") ){
                j = Integer.parseInt(st.nextToken());
                Node bp_prev = node.prev;
                bw.write( node.prev.val +"\n" );
                node.prev = new Node(j);
                node.prev.prev = bp_prev;
                node.prev.next = node;
                bp_prev.next = node.prev;
                map[j] = node.prev;
            } else if( method.equals("CP") ){
                bw.write( node.prev.val +"\n" );
                node.prev = node.prev.prev;
                node.prev.next = node;
            } else {
                bw.write( node.next.val  +"\n");
                node.next = node.next.next;
                node.next.prev = node;
            }
        }
        bw.flush();
        bw.close();
    }
    
    public static class Node{
        public int val;
        public Node prev;
        public Node next;
        
        public Node(int v){
            this.val = v;
            this.prev = null;
            this.next = null;
        }
    }
    
}
