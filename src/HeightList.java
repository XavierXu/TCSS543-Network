import java.util.LinkedList;

/**
 * @author Mounica
 */
public class HeightList {
    private int itemCount;
    private int maxHeightIndex;
    private LinkedList<Vertex>[] list;

    public int getMaxHeightIndex() {
        return maxHeightIndex;
    }

    public HeightList(int size){
        this.itemCount = 0;

        this.maxHeightIndex = 0;

        list = new LinkedList[size];

        for(int i = 0; i < size; i++){
            list[i] = new LinkedList<Vertex>();
        }
    }

    public boolean isEmpty(){
        return itemCount == 0;
    }

    public void add(int index, Vertex v){
        list[index].add(v);
        if(index > maxHeightIndex){
            maxHeightIndex = index;
        }
        itemCount++;
    }

    public void remove(int index, Vertex v){
        list[index].remove(v);
        if(maxHeightIndex == index && list[index].size() == 0) {
            while (maxHeightIndex >= 0) {
                if(list[maxHeightIndex].size() != 0){
                    break;
                }
                maxHeightIndex--;
            }
        }
        itemCount--;
    }

    public boolean contains(int index, Vertex v){
        return list[index].contains(v);
    }

    public Vertex getFirst(int index){
        return list[index].getFirst();
    }

    public int getListSize(int index){
        return list[index].size();
    }

}
