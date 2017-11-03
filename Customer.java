package com.egh.action;

public class Customer extends Action{
	private CustomerDAO customerDAO=null;
	private ChStr chStr=new ChStr;
	public Customer(){
		this.customerDAO =new CustomerDAO();
	}
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		String action=request.getParameter("action");
		System.out.println("Get the searching string:"+action);
		if(action==null||"".equals(action)){
			request.setAttribute("error","Wrong action!!!");
			return mapping.findForward("error");
		}
		else if("customerQuery".equals(action)){
			return customerQuery(mapping,form,request,response);
		}
		else if("customer add".equals(action)){
			return customerAdd(mapping,form,request,response);
		}
		else if("customerDel".equals(action)){
			return customerDel(mapping,form,request,response);
		}
		else if("customerQueryModify".equals(action)){
			return customerModify(mapping,form,request,response);
		}
		else if("customermodify".equals(action)){
			return customerModify(mapping,form,request,response);
		}
		request.setAttribute("erroe","Failed");
		return mapping.findForward("error");
	}
	private ActionForward customerAdd(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		CustomerForm customerForm=(CustomerForm) form;
		customerForm.setName(chStr.toChiness(customerForm.getName()));
		customerForm.setAddress(chStr.toChiness(customerForm.getAddress()));
		customerForm.setArea(chStr.toChiness(customerForm.getArea()));
		customerForm.setBankName(chStr.toChiness(customerForm.getBankName()));
		customerForm.setLinkName(chStr.toChiness(customerForm.getinkName()));
		int ret=customerDAO.insert(customerForm);
		System.out.println("Return value:"+ret);
		if(ret==1){
			return mapping.findForward("customerAdd");
		}
		else if(ret==2){
			request.setAttribute("error","The client's information have been added!");
			return mapping.findForward("error");
		}
		else{
			request.setAttribute("error","Failing to add client's information");
			return mapping.findForward("error");
		}
	}
	private ActionForward customerQueryModify(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("customerQuery",customerDAO.query(Integer.parseInt(request.getParameter("id"))));
		return mapping.findForward("customerQuery",customerDAO.queryInterger);
	}
	private ActionForward customerModify(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		CustomerForm customerForm=(CustomerForm) form;
		customerForm.setName(chStr.toChiness(customerForm.getName()));
		customerForm.setAddress(chStr.toChiness(customerForm.getAddress()));
		customerForm.setArea(chStr.toChiness(customerForm.getArea()));
		customerForm.setBankName(chStr.toChiness(customerForm.getBankName()));
		customerForm.setLinkName(chStr.toChiness(customerForm.getinkName()));
		int ret=customerDAO.update(customerForm);
		if(ret==0){
			request.setAttribute("error","Failing to modify client's information");
			return mapping.findForward("error");
		}
		else{
			return mapping.findForward("customerModify");
		}
	}
	private ActionForward customerDel(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		customerForm customerForm=(CustomerForm) form;
		customerForm.setID(Integer.parseInt(request.getParameter("id")));
		if(ret==0){
			request.setAttribute("error","Failing to delete client's information!");
			return mapping.findForward("error");
		}
		else{
			return mapping.findForward("customerDel");
		}
	}
}
