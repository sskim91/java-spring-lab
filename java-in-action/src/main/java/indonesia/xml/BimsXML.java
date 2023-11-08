package indonesia.xml;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sskim
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "BIMSXML")
public class BimsXML {

    @XmlElementWrapper(name = "Nodes")
    @XmlElementRef
    private List<StationNode> stationNodeList;

    @XmlElementWrapper(name = "Lines")
    @XmlElementRef
    private List<Route> lines;

    public void addNodes(StationNode stationNode) {
        if (stationNodeList == null) {
            stationNodeList = new ArrayList<>();
        }
        stationNodeList.add(stationNode);
    }

    public void addLines(Route route) {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        lines.add(route);
    }

}
