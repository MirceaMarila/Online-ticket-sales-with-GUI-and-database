package datetimeplace;

public class DateTime
{

    private int ziua;
    private int luna;
    private int an;
    private int ora;
    private int min;

    public DateTime()
    {

    }

    public DateTime(int ziua, int luna, int an, int ora, int min)
    {
        this.ziua = ziua;
        this.luna = luna;
        this.an = an;
        this.ora=ora;
        this.min=min;
    }

    public int getZiua()
    {
        return ziua;
    }

    public void setZiua(int ziua) {
        this.ziua = ziua;
    }

    public int getLuna()
    {
        return luna;
    }

    public void setLuna(int luna)
    {
        this.luna=luna;
    }

    public int getAn()
    {
        return an;
    }

    public void setAn(int an)
    {
        this.an=an;
    }

    public int getOra()
    {
        return ora;
    }

    public void setOra(int ora)
    {
        this.ora=ora;
    }

    public int getMin()
    {
        return min;
    }

    public void setMin(int min)
    {
        this.min=min;
    }

}
