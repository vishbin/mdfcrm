package mdf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mdf.dao.GenerateAgentStatDAO;
import mdf.forms.GenerateReportFormBean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GenerateAgentStatAction extends BaseAction {
    public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
        throws Exception {

    	String  myActionForward = null;
    	//use Spring AOP dude!
        log.info("inside execute method for GenerateAgentStatAction");

        GenerateReportFormBean myGenerateReportFormBean = (GenerateReportFormBean) form;
        //GenerateReportFormBean myGenerateReportFormBean = (GenerateReportFormBean)session.getAttribute("reportbean");
      //  GenerateReportFormBean myGenerateReportFormBean = new GenerateReportFormBean();
        GenerateAgentStatDAO myGenerateAgentStatDAO= new GenerateAgentStatDAO();

        //TODO use dispatchaction
       myActionForward="success";
        if (myGenerateReportFormBean.getActions().equalsIgnoreCase("yest")){
        	myGenerateAgentStatDAO.generateStatForYest(myGenerateReportFormBean);
        }else if (myGenerateReportFormBean.getActions().equalsIgnoreCase("today")){
        	myGenerateAgentStatDAO.generateStatForToday(myGenerateReportFormBean);
        }else if (myGenerateReportFormBean.getActions().equalsIgnoreCase("3days")){
        	myGenerateAgentStatDAO.generateStatAtAGlance(myGenerateReportFormBean);
        	myActionForward="cust_lists";
        }else{
        	myGenerateAgentStatDAO.generateStatForAllAgent(myGenerateReportFormBean);
        }
        //session.setAttribute("reportbean", myGenerateReportFormBean);
        return (mapping.findForward(myActionForward));

    }

}
