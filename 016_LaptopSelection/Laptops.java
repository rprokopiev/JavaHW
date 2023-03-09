public class Laptops {
    private String name;
    private int ram;
    private int hd;
    private String os;
    private String color;

    public Laptops(String name, int ram, int hd, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Laptops [name=" + name + ", ram=" + ram + ", hd=" + hd + ", os=" + os + ", color=" + color + "]";
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getHd() {
        return hd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ram;
        result = prime * result + hd;
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptops other = (Laptops) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (ram != other.ram)
            return false;
        if (hd != other.hd)
            return false;
        if (os == null) {
            if (other.os != null)
                return false;
        } else if (!os.equals(other.os))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }
}