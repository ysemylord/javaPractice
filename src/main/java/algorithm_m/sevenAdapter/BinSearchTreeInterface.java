package algorithm_m.sevenAdapter;

import algorithm_m.fiveAdapter.binTree.BinTree;

public interface BinSearchTreeInterface {
    BinTree.BinNode search(int e);
    BinTree.BinNode insert(int e);
    boolean remove(int e);
}
