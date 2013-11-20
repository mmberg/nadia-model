@XmlSchema(
	    namespace = "http://mmberg.net/nadia/"+net.mmberg.nadia.dialogmodel.definition.DialogModel.VERSION, 
	    xmlns={@XmlNs(namespaceURI = "http://mmberg.net/nadia/"+net.mmberg.nadia.dialogmodel.definition.DialogModel.VERSION, prefix = "n")},
	    elementFormDefault = XmlNsForm.UNQUALIFIED,
	    attributeFormDefault = XmlNsForm.UNQUALIFIED
		)
package net.mmberg.nadia.processor.dialogmodel;

import javax.xml.bind.annotation.*;