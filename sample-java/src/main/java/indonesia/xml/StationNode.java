package indonesia.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author sskim
 */
@ToString
@Setter
@Getter
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Node")
public class StationNode {

    @XmlAttribute
    private String code;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Label")
    private String label;

    @XmlElement(name = "Vertex")
    @XmlElementWrapper(name = "Vertices")
    private List<Vertex> vertex;

//    @XmlElementRef
//    private List<InnerStationNode> stationNodeList = new ArrayList<>();
//
//    public StationNode() {
//        InnerStationNode innerStationNode = new InnerStationNode();
//        innerStationNode.setCode("11");
//        innerStationNode.setName("22");
//        innerStationNode.setLabel("33");
//        List<Vertex> vertices = Arrays.asList(new Vertex("1", "2"), new Vertex("4", "3"));
//        innerStationNode.setVertex(vertices);
//        stationNodeList.add(innerStationNode);
//    }
//
//    @Getter
//    @Setter
//    @XmlAccessorType(XmlAccessType.NONE)
//    @XmlRootElement(name = "Node")
//    private static class InnerStationNode {
//
//        @XmlAttribute
//        private String code;
//
//        @XmlElement(name = "Name")
//        private String name;
//
//        @XmlElement(name = "Label")
//        private String label;
//
//        @XmlElement(name = "Vertex")
//        @XmlElementWrapper(name = "Vertices")
//        private List<Vertex> vertex;
//    }

}
