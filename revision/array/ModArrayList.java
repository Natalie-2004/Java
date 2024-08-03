package revision.array;

import java.util.ArrayList;

// cast type: D -> any type of data
public class ModArrayList<D> extends ArrayList<D> {

    public D getUsingMod(int index) {
        int validInd = Math.abs(index % this.size());
        return this.get(validInd);
    }
}
