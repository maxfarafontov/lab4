package Data;

public class Distance {
    public Integer id, distance, distwater;
    String style;

    public Distance(Integer id, String style, Integer distance, Integer diswater){

        this.id = id;
        this.distance = distance;
        this.distwater = diswater;
        this.style = style;

    }
    public Distance( String style, Integer distance, Integer diswater){

        this.distance = distance;
        this.distwater = diswater;
        this.style = style;

    }
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistwater() {
        return distwater;
    }

    public void setDistwater(Integer distwater) {
        this.distwater = distwater;
    }


    @Override
    public String toString() {
        return "(" + "'" + style + "','" + distance + "','" + distwater + "')";
    }
}
