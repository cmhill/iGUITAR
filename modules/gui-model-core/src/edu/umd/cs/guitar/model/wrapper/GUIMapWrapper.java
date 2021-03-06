/*  
 *  Copyright (c) 2009-@year@. The GUITAR group at the University of Maryland. Names of owners of this group may
 *  be obtained by sending an e-mail to atif@cs.umd.edu
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 *  documentation files (the "Software"), to deal in the Software without restriction, including without 
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *  the Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 *  conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all copies or substantial 
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 *  LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO 
 *  EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 *  THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package edu.umd.cs.guitar.model.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import edu.umd.cs.guitar.model.data.ComponentType;
import edu.umd.cs.guitar.model.data.EventType;
import edu.umd.cs.guitar.model.data.GUIMap;
import edu.umd.cs.guitar.model.data.ObjectFactory;
import edu.umd.cs.guitar.model.data.WidgetMapElementType;

/**
 * The wrapper for <code>GUIMap </code>
 * <p>
 * 
 * @author <a href="mailto:baonn@cs.umd.edu"> Bao N. Nguyen </a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "eventMap", "widgetMap" })
@XmlRootElement(name = "GUIMap")
public class GUIMapWrapper extends GUIMap
{

    static ObjectFactory factory = new ObjectFactory();

    public GUIMapWrapper(GUIMap map)
    {

        if (map.getEventMap() == null)
            this.eventMap = factory.createEventMapType();
        else
            this.eventMap = map.getEventMap();

        if (map.getWidgetMap() == null)
            this.widgetMap = factory.createWidgetMapType();
        else
            this.widgetMap = map.getWidgetMap();
    }

    /**
     * get widget map from event id
     * 
     * @param eID
     *            event id
     * @return
     */
    public WidgetMapElementType getWidgetMap(String eID)
    {
        EventMapWrapper wEM = new EventMapWrapper(this.getEventMap());
        WidgetMapWrapper wWM = new WidgetMapWrapper(this.getWidgetMap());

        // Look up event from ID
        EventType event = wEM.getEvent(eID);
        if (event == null)
            return null;

        // Look up widgetID type from event
        String wID = event.getWidgetId();
        if (wID == null)
            return null;

        // Look up widget map element from widget ID
        WidgetMapElementType wMap = wWM.getWidgetMap(wID);

        return wMap;

    }

    /**
     * get a widget property from event id
     * 
     * @param eID
     *            event id
     * @return
     */
    public String getWidgetProperty(String eID, String property)
    {
        String value = null;
        if (eID == null)
            return value;

        WidgetMapElementType widget = getWidgetMap(eID);
        if (widget != null)
        {
            ComponentType component = widget.getComponent();
            ComponentTypeWrapper wComponent = new ComponentTypeWrapper(component);
            value = wComponent.getFirstValueByName(property);
        }

        return value;

    }

    // /**
    // * Convert from event ID to a widget property. This method is used to
    // * convert event ID to some readable string
    // *
    // * @return
    // */
    // public String toProperty(String eventID, String property)
    // {
    //
    // String value = null;
    // if (eventID == null)
    // return value;
    //
    // WidgetMapElementType widget = getWidgetMap(eventID);
    // if (widget != null)
    // {
    // ComponentType component = widget.getComponent();
    // ComponentTypeWrapper wComponent = new ComponentTypeWrapper(component);
    // value = wComponent.getFirstValueByName(property);
    // }
    //
    // return value;
    // }
}
