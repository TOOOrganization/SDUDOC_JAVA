package cn.edu.sdu.sdudoc.util;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageInfo{

    private String src = "";
    private String id = "";
    private double width = 0;
    private double height = 0;
    private double scale_width = 0;
    private double scale_height = 0;
    private double max_width = 0;
    private double max_height = 0;
    private double scale = 1;
    private double x = 0;
    private double y = 0;

    private String polygons = "";

    public PageInfo(HashMap<String, String> map){
        this.src = map.get("src");
        this.id = map.get("id");
        this.width = Double.parseDouble(map.get("width"));
        this.height = Double.parseDouble(map.get("height"));
        this.polygons = "";
        this.max_width = 0;
        this.max_height = 0;
        this.scale_width = 0;
        this.scale_height = 0;
        this.scale = 1;
        this.x = 0;
        this.y = 0;
    }

    public void setScale(String max_w, String max_h){
        this.max_width = Double.parseDouble(max_w);
        this.max_height = Double.parseDouble(max_h);
        double scale_x = this.max_width / this.width;
        double scale_y = this.max_height / this.height;
        this.scale = Math.min(scale_x, scale_y);
        this.scale_width = this.width * this.scale;
        this.scale_height = this.height * this.scale;
        this.x = (max_width - scale_width) / 2;
        this.y = (max_height - scale_height) / 2;
    }

    public void addPolygon(List<String> list){
        this.polygons += "<polygon points=\"";
        for (int i = 0; i < list.size(); i++) {
            String b_point_xy = list.get(i).replace("\"","");
            String a_point_xy = b_point_xy.substring(1,b_point_xy.length()-1);
            String[] point_xy = a_point_xy.split(",");
            double x = this.x + Double.parseDouble(point_xy[0]) * this.scale;
            double y = this.y + Double.parseDouble(point_xy[1]) * this.scale;
            this.polygons += x + "," + y + " ";
        }
        this.polygons = this.polygons.substring(0, this.polygons.length() - 1);
        this.polygons += "\" style=\"fill:red;fill-opacity:0.5\"/>\n";
    }

    public String toString(){
        return "<svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" " +
                "xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "x=\"0px\" y=\"0px\" width=\"" + this.max_width + "\" height=\"" + this.max_height + "\" " +
                "viewBox=\"0 0 " + this.max_width + " " + this.max_height + "\" " +
                "xml:space=\"preserve\">  \n" +
                "<image id=\"image0\" x=\"" + this.x + "\" y=\"" + this.y + "\" width=\"" + this.scale_width +
                "\" height=\"" + this.scale_height + "\" href=\""+ this.src+"\" />\n" +
                this.polygons +
                "</svg>";
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getId() {
        return id;
    }
}
