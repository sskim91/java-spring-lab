package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sskim
 */
@ToString
@Setter
@Getter
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Route")
public class RouteNode {

    @XmlAttribute
    private String code;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Longitud")
    private String longitude;

    @XmlElement(name = "Destination")
    private String destination;

    @XmlElementWrapper(name = "Nodes")
    @XmlElementRef
    private List<RouteStationNode> nodes;

    @XmlElementWrapper(name = "Vertices")
    @XmlElementRef
    private List<Vertex> vertices;

    public void addNode(RouteStationNode node) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
    }

    public void addVertex(Vertex vertex) {
        if (vertices == null) {
            vertices = new ArrayList<>();
        }
        vertices.add(vertex);
    }

}
