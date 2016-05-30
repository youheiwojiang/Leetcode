public class Vector2D implements Iterator<Integer> {
    Iterator<Integer>ite2;
    Iterator<List<Integer>>ite1;
    public Vector2D(List<List<Integer>> vec2d) {
        ite1 = vec2d.iterator();
        //ite2 = ite1.next().iterator();
        }

    @Override
    public Integer next() {
        hasNext();
        return ite2.next();
    }

    @Override
    public boolean hasNext() {
        while((ite2 == null || !ite2.hasNext()) && ite1.hasNext() )
            ite2 = ite1.next().iterator();
        return ite2 != null && ite2.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
