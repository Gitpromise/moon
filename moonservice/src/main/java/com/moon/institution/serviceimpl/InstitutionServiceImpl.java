package com.moon.institution.serviceimpl;


import com.moon.base.page.PageResult;
import com.moon.base.utils.Constant;
import com.moon.base.utils.DataUtil;
import com.moon.institution.dao.IInstitutionDao;
import com.moon.institution.dto.InstitutionCondition;
import com.moon.institution.entity.Institution;
import com.moon.institution.service.IInstitutionService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("institutionServiceImpl")
@Transactional(value = "transactionManager")
public class InstitutionServiceImpl implements IInstitutionService {

	//private static final Logger logger = Log..getLogger(InstitutionServiceImpl.class);
	
	// 认证字段数量

	private final Integer AUTHENTCATION_COUNT = 53;

	// 机构图片
	private final String INSTITUTION_PHOTO = "1";
	// 机构优势特点
	private final String INSTITUTION_ADVANTAGE = "2";
	// 机构设备图片
	private final String INSTITUTION_DEVICES = "3";
	// 机构证件图片
	private final String INSTITUTION_CERTIFICATES = "4";
	
	// 机构图片
	private String [] institutionPhotoArr = new String[]{
		Constant.CLINIC_APPEARANCE,Constant.RECEPTION,Constant.CONSULTING_ROOM,Constant.WAITING_AREA,
		Constant.RADIOLOGY_ROOM,Constant.DENTAL_UNIT,Constant.DISINFECTION_ROOM
	};

	@Resource(name = "institutionDao")
	private IInstitutionDao institutionDao;
	/*@Resource(name = "institutionCheckDaoImpl")
	private IInstitutionCheckDao institutionCheckDao;
	@Resource(name = "institutionMachineDaoImpl")
	private IInstitutionMachineDao institutionMachineDao;
	@Resource(name = "sysUploadFileDaoImpl")
	private ISysUploadFileDao sysUploadFileDao;
	@Resource(name = "memberAssessServiceImpl")
	private IMemberAssessService memberAssessService;
	@Resource
	private IInstitutionActivityDao institutionActivityDao;

	@Resource
	private ICardDao cardDao;
	
	@Resource
	private ICodeProvinceDao codeProvinceDao;
	@Resource
	private ICodeCityDao codeCityDao;
	@Resource
	private ICodeAddressDao codeAddressDao;

	@Resource(name = "sysDictItemDaoImpl")
	private ISysDictItemDao sysDictItemDao;
	@Resource(name = "institutionServiceImpl")
	private IInstitutionService institutionService;
	@Resource(name = "institutionCheckServiceImpl")
	private IInstitutionCheckService institutionCheckService;
	@Resource(name = "institutionAppointSetServiceImpl")
	private IInstitutionAppointSetService institutionAppointSetService;
	@Resource(name = "sysUploadFileServiceImpl")
	private ISysUploadFileService sysUploadFileService;
	@Resource(name = "institutionExpertServiceImpl")
	private IInstitutionExpertService institutionExpertService;
	@Resource(name = "institutionServiceItemServiceImpl")
	private IInstitutionServiceItemService institutionServiceItemService;
	@Resource(name = "institutionAppointArrangeServiceImpl")
	private IInstitutionAppointArrangeService institutionAppointArrangeService;
	@Resource(name="collectDaoImpl")
	private ICollectDao collectDao;
	@Resource(name = "serviceItemServiceImpl")
	private IServiceItemService serviceItemService;*/
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listInstitutionByPage(PageResult<Institution> pageResult,InstitutionCondition condition){
		/*int rows = institutionDao.listInstitutionByPageCount(condition);
		pageResult.setRows(rows);
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listInstitutionByPage(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/
	}


	public void listInstitutionByPageByadmin(PageResult<Institution> pageResult,InstitutionCondition condition){

		/*int rows = institutionDao.listInstitutionByPageByadminCount(condition);
		pageResult.setRows(rows);
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listInstitutionByPageByadmin(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/

	}

	/**
	 * 根据服务名称查询数据
	 * @param condition 条件
	 */
	public void listInstitutionByPageService(PageResult<Institution> pageResult,InstitutionCondition condition) {
		// 服务项目集合
		/*String id=null;
		List<ServiceItem> serviceItemByOneList = serviceItemService.listServiceItemByParent();
		for (int i=0;i<serviceItemByOneList.size();i++){
			if(condition.getServiceName().equals(serviceItemByOneList.get(i).getName())){
				id=serviceItemByOneList.get(i).getId();
			}
			}
			if(id!=null&&id.length()>0){
				condition.setServerItemId(id);
			 listInstitutionByPage( pageResult, condition);
				return;
			}
		int rows = institutionDao.listInstitutionByPageServicecount(condition);
		pageResult.setRows(rows);
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listInstitutionByPageService(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/
	}

	/**
	 * 首页分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listInstitutionByshouye(PageResult<Institution> pageResult,InstitutionCondition condition){

		List<Institution> list = institutionDao.listInstitutionByshouye(condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}

		pageResult.setResult(list);
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 机构信息
	 */
	public Institution getInstitutionById(String id){
		return institutionDao.getInstitutionById(id);
	}

	/**
	 * 根据条件查询机构
	 * @return
	 */
	public List<Institution> listInstitutionByCondition(InstitutionCondition condition){
		return institutionDao.listInstitutionByCondition(condition);
	}
	
	/**
	 * 新增
	 * @param item 机构信息
	 */
	
	public void add(Institution item){
		//加密
		item.setPassword(DataUtil.encryptionPw(item.getPassword()));
		institutionDao.add(item);
	}

	/**
	 * 修改
	 * @param item 机构信息
	 */
	public void update(Institution item){
		institutionDao.update(item);
	}

	/**
	 * 修改机构的登录账号
	 * @param
	 */
	public void updateAccount( String institutionId,String newAccount){
		Institution item = institutionDao.getInstitutionById(institutionId);
		item.setAccount(newAccount);
		institutionDao.update(item);
	}
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		institutionDao.delByIds(ids);
	}

	public void resetPwd(Institution item) {
		institutionDao.resetPwd(item);
	}

	/**
	 * 验证用户名是否存在
	 * @param
	 * @param
	 */
	public boolean alreadyExists(String account){
		Institution institution = institutionDao.getInstitutionByAccount(account);
		boolean res = true;
		if(institution == null ){
			res = true;
		}else{
			res = false;
		}
		return res;
	}
	
	
	
	
	

	public void updateIsRecommendByIds(Integer isRecommend, String[] ids) {
		
		institutionDao.updateIsRecommendByIds(isRecommend, ids);
	}

	public void updateStatusByIds(Integer status, String[] ids) {
		institutionDao.updateStatusByIds(status, ids);
	}

	public List<Institution> listInstitutionByKey(String key) {
		return institutionDao.listInstitutionByKey(key);
	}

	public void updateUsingStatus(String[] ids, Integer usingStatus) {
		institutionDao.updateUsingStatus(ids, usingStatus);
		
	}



	public List<Institution> listInstitutionAllByUsingStatusAndStatus() {
		return institutionDao.listInstitutionAllByUsingStatusAndStatus();
	}

	public List<Institution> listInstitutionAllByUsingStatusAndStatusAndIsRecommend() {
		return institutionDao.listInstitutionAllByUsingStatusAndStatusAndIsRecommend();
	}

	public Institution getInstitutionByAccountAndPwd(String account,
			String password) {
		return institutionDao.getInstitutionByAccountAndPwd(account, password);
	}

	

	
	public void updateFlagbyIds(String[] ids, Integer deleteFlag) {
		institutionDao.updateFlagbyIds(ids, deleteFlag);
	}

	public void updateAuthentcationStatusReasonById(Integer authentcationStatus, String reason, String[] ids) {
		institutionDao.updateAuthentcationStatusReasonById(authentcationStatus, reason, ids);
	}

	public Institution getInstitutionByAccount(String account) {
		return institutionDao.getInstitutionByAccount(account);
	}

	public Institution getInstitutionByInstitutionNo(String institutionNo) {
		return institutionDao.getInstitutionByInstitutionNo(institutionNo);
	}

	public Institution getInstitutionByItem(Institution item) {
		/*List<MemberAssess> memberAssessList=memberAssessService.listMemberAssessByInstitutionId(item.getId());
		if(memberAssessList.size()<=0){
			return item;
		}
		*//** （机构评价）总评价（1：好评，2：中评，3：差评） *//*
		 Double assess=0D;
		 *//**好评 *//*
		 Double good=0D;
		*//**好评 *//*
		 Double average=0D;
		*//**差评 *//*
		 Double bad=0D;
		*//** （机构评价）技术水平 *//*
		 Double technical=0D;
		*//** （机构评价）就诊环境 *//*
		 Double setting=0D;
		*//** （机构评价）服务态度 *//*
		 Double attitude=0D;
		*//** （机构评价）等候时间 *//*
		 Double waiting=0D;
		//得到机构各项总评分
		for (MemberAssess memberAssess : memberAssessList) {
			technical+=memberAssess.getTechnical();
			setting+=memberAssess.getSetting();
			attitude+=memberAssess.getAttitude();
			waiting+=memberAssess.getWaiting();
			switch (memberAssess.getMark()) {
			case 1:
				good++;
				break;
			case 2:
				average++;
				break;
			case 3:
				bad++;
				break;
			}
		}
		//算出机构各项综合评分	
		technical=technical/memberAssessList.size();
		setting=setting/memberAssessList.size();
		attitude=attitude/memberAssessList.size();
		waiting=waiting/memberAssessList.size();
		good=Utils.round((good/memberAssessList.size()),1);
		average=Utils.round((average/memberAssessList.size()),1);
		bad=Utils.round((bad/memberAssessList.size()),1);
		assess=Utils.round(((technical+setting+attitude+waiting)/4),1);
		//存入机构各项综合评分	
		item.setTechnical(technical*20);
		item.setSetting(setting*20);
		item.setAttitude(attitude*20);
		item.setWaiting(waiting*20);
		item.setGood(good*100);
		item.setAverage(average*100);
		item.setBad(bad*100);
		item.setAssess(assess*20);*/
		
		return item;
	}

	public void listFastCheckbByPage(PageResult<Institution> pageResult,InstitutionCondition condition) {
		/*int rows = institutionDao.listFastCheckByPageCount(condition);
		pageResult.setRows(rows);	
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listFastCheckByPage(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/
	}
	
	/*public List<InstitutionCityVO> listInstitutionCities() {
		return institutionDao.listInstitutionCities();
	}
*/
	public boolean getInstitutionByAccountExists(String account, String id) {
		return institutionDao.getInstitutionByAccountExists(account, id);
	}


	/**
	 * 按照预约人数降序排序
	 * @param condition
	 * @return
	 */
	public void listInstitutionByPageYuYue(PageResult<Institution> pageResult,InstitutionCondition condition){
		/*int rows = institutionDao.listInstitutionByPageCount(condition);
		pageResult.setRows(rows);	
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());

		List<Institution> list = institutionDao.listInstitutionByPageYuYue(rowBounds, condition);

		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}

		pageResult.setResult(list);*/
	}
	/**
	 * 按照评价降序排序
	 * @param condition
	 * @return
	 */
	public void listInstitutionByPageAssess(PageResult<Institution> pageResult,InstitutionCondition condition){
		/*int rows = institutionDao.listInstitutionByPageCount(condition);
		pageResult.setRows(rows);	
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listInstitutionByPageAssess(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/
	}
	/**
	 * 只查询推荐的
	 * @param condition
	 * @return
	 */
	public void listInstitutionByPageRecommend(PageResult<Institution> pageResult,InstitutionCondition condition){
		/*int rows = institutionDao.listInstitutionByPageCount(condition);
		pageResult.setRows(rows);	
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list = institutionDao.listInstitutionByPageRecommend(rowBounds, condition);
		for (Institution institution : list) {
			institution=getInstitutionByItem(institution);
		}
		pageResult.setResult(list);*/
	}


	public void updateRecommend(Institution item) {
		institutionDao.updateRecommend(item);
		
	}
	
	/**
	 * 机构信息导出
	 * @author hys
	 * @param condition
	 * @return
	 */
	public String doExport(InstitutionCondition condition){
		/*int count = institutionDao.listInstitutionByPageCount(condition);
		RowBounds rowBound = new RowBounds(0,count);
		List<Institution> list  =  institutionDao.listInstitutionByPage(rowBound, condition);
		HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("机构信息");
        String [] titles = new String[]{"机构编号","机构名称","启用状态","合约","推荐","推荐度","状态","登录账号","行政负责人","行政负责人手机号码","门诊电话","邮箱","省","市","区","地址","认证度"}; 
        //列宽
        Integer[] titleWidths = new Integer[]{15,25,10,10,10,8,20,20,15,15,15,20,20,20,20,20,20};
        // 列头
        HSSFRow row = ExcelUtil.createHSSFRow(titles, titleWidths, wb, sheet, 0);
		HSSFCellStyle cellStyles= ExcelUtil.createHSSFCellStyle(wb);
        for(int i = 0; i < list.size(); i++){
        	row = sheet.createRow(i+1);
        	Institution item = list.get(i);
        	ExcelUtil.createCell(cellStyles, row,0).setCellValue(item.getInstitutionNo());
        	ExcelUtil.createCell(cellStyles, row,1).setCellValue(item.getName());
        	String usingStatus = "";
        	if(item.getUsingStatus().intValue() == 0){
        		usingStatus="启用";
        	}else if(item.getUsingStatus().intValue() == 1){
        		usingStatus="禁用";
       	}
        	ExcelUtil.createCell(cellStyles, row,2).setCellValue(usingStatus);
        	String hyUrl ="--";
        	if(StringUtils.isNotBlank(item.getHyUrl())){
        		hyUrl =item.getHyUrl();
        	}
        	ExcelUtil.createCell(cellStyles, row,3).setCellValue(hyUrl);
        	String isRecommend ="";
        	*//** 是否推荐，0-否，1-是 *//*
        	if(item.getIsRecommend().intValue() == 0){
        		isRecommend="否";
        	}else if(item.getIsRecommend().intValue() == 1){
        		isRecommend="是";
        	}
        	ExcelUtil.createCell(cellStyles, row,4).setCellValue(isRecommend);
        	ExcelUtil.createCell(cellStyles, row,5).setCellValue(item.getRecommend());
        	String status ="";
        	if(item.getStatus().intValue() ==0){
        		status ="注册完成";
        	}else if(item.getStatus().intValue() ==1){
        		status ="基本信息已完善";
        	}else if(item.getStatus().intValue() ==2){
        		status ="资料已完善";
        	}else if(item.getStatus().intValue() ==3){
        		status ="预约已设定";
        	}else if(item.getStatus().intValue() ==4){
        		status ="已上传合约";
        	}else if(item.getStatus().intValue() ==5){
        		status ="已签订合约,待审核";
        	}else if(item.getStatus().intValue() ==6){
        		status ="审核通过";
        	}else if(item.getStatus().intValue() ==7){
        		status ="审核不通过";
        	}else{
        		status ="--";
        	}
        	ExcelUtil.createCell(cellStyles, row,6).setCellValue(status);
        	
        	ExcelUtil.createCell(cellStyles, row,7).setCellValue(item.getAccount());
        	InstitutionCheck  institutionCheck=institutionCheckDao.getInstitutionCheckByInstitutionNo(item.getInstitutionNo());
			item.setInstitutionCheck(institutionCheck);
			if(institutionCheck == null){
				ExcelUtil.createCell(cellStyles, row,8).setCellValue("");
	        	ExcelUtil.createCell(cellStyles, row,9).setCellValue("");
	        	ExcelUtil.createCell(cellStyles, row,10).setCellValue("");
	        	ExcelUtil.createCell(cellStyles, row,11).setCellValue("");
			}else{
				ExcelUtil.createCell(cellStyles, row,8).setCellValue(item.getInstitutionCheck().getExecutive());
	        	ExcelUtil.createCell(cellStyles, row,9).setCellValue(item.getInstitutionCheck().getExecutivePhone());
	        	ExcelUtil.createCell(cellStyles, row,10).setCellValue(item.getInstitutionCheck().getLinkTel());
	        	ExcelUtil.createCell(cellStyles, row,11).setCellValue(item.getInstitutionCheck().getEmail());
			}
			ExcelUtil.createCell(cellStyles, row,12).setCellValue(item.getInstitutionCheck().getProvinceName());
			ExcelUtil.createCell(cellStyles, row,13).setCellValue(item.getInstitutionCheck().getCityName());
			ExcelUtil.createCell(cellStyles, row,14).setCellValue(item.getInstitutionCheck().getDistrictName());
			ExcelUtil.createCell(cellStyles, row,15).setCellValue(item.getAddress());
			if(item.getAuthentcationRate()==null){
				item.setAuthentcationRate(0);
			}
			ExcelUtil.createCell(cellStyles, row,16).setCellValue(item.getAuthentcationRate());
        }
       return ExcelUtil.exportAjaxExcelData("机构信息导出", wb);*/
		return null;
	
	}

	public void updateHyUrlById(String hyUrl, Integer status, String id) {
		institutionDao.updateHyUrlById(hyUrl, status, id);
	}

	/**
	 * 手机端分页
	 * @param pageResult
	 * @param condition
	 */
	public void listMobileByPage(PageResult<Institution> pageResult,InstitutionCondition condition) {
		/*int count = institutionDao.listMobileByPageCount(condition);
		pageResult.setRows(count);
		RowBounds bounds = new RowBounds(pageResult.getCurrentPageIndex(), pageResult.getPageSize());
		List<Institution> list = institutionDao.listMobileByPage(bounds, condition);
		pageResult.setResult(list);*/
	}



	public List<Institution> listByCondition(PageResult<Institution> pageResult,InstitutionCondition condition) throws Exception {
		/*int count = institutionDao.listByConditionCountNum(condition);
		pageResult.setRows(count);
		RowBounds bounds = new RowBounds(pageResult.getCurrentPageIndex(), pageResult.getPageSize());
		List<Institution> list = institutionDao.listByCondition(bounds,condition);
		for (Institution item : list) {
			InstitutionCheck check = institutionCheckDao.getInstitutionCheckByInstitutionNo(item.getInstitutionNo());
			if(null != check){
				item.setInstitutionCheck(check);
				if(null == check.getLat() && null == check.getLng()){
					//得到经纬度
					Map<String,String> map = BaiduMapUtil.geocoding(check.getCityName(), check.getDistrictName()+check.getAddress());
					if(null != map){
						double lng = Double.parseDouble(map.get("lng").toString());
						double lat = Double.parseDouble(map.get("lat").toString());
						check.setLng(lng);
						check.setLat(lat);
						//更新
						institutionCheckDao.updateCoord(check);
					}
				}
				if(null != condition.getLat() && null != condition.getLng()){
					if(!StringUtils.isBlank(check.getLat()+"")&&!StringUtils.isBlank(check.getLng()+"")) {
						double distance = BaiduMapUtil.getDistance(condition.getLat(), condition.getLng(), check.getLat(), check.getLng());
						item.setDistance(distance);
					}

				}
			}
		}
		pageResult.setResult(list);*/
		List list=new ArrayList();
		return list;
	}

	/*public List<InstitutionImportData> batchImport(String filePath,String currentOperatorUserAccount) {
		System.out.println("进入导入方法------\n\n\n\n");
		List<InstitutionImportData> result = new ArrayList<InstitutionImportData>();
		String tmpPath = "/institution_tmp";
		String tempDestPath = ServletActionContext.getServletContext().getRealPath(tmpPath);
		File tmpDir = new File(tempDestPath);
		if (!tmpDir.exists()){
			tmpDir.mkdirs();
		}
		String fileExt = Utils.getExtention(filePath);
		File destFile = new File (tempDestPath+Constant.FILESPEARATOR+UUIDUtil.uuid()+fileExt);
		InputStream is = null;
		OutputStream out = null;
		try {
			out = new FileOutputStream(destFile);
			FtpClientUtils.downFile(Constant.FILESPEARATOR+Constant.INSTITUTION_UPLLOAD+Constant.FILESPEARATOR+filePath,out);
			is = new FileInputStream(destFile);
			// 根据上述创建的输入流 创建工作簿对象 
			HSSFWorkbook wb = new HSSFWorkbook(is);
			// 得到第一页 sheet,Sheet是从0开始索引的 
			HSSFSheet sheet = wb.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				HSSFRow row = sheet.getRow(i);
				if(null == row){
					continue;
				}
				// 1.获取单元格的值
				String account = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(0)),"");
			
				// 机构名称
				String name = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(1)),"");
				// 门诊电话
				String tel = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(2)),"");
				// 联系人
				String linkPerson = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(3)),"");
				// 联系手机
				String phone = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(4)),"");
				// 邮箱
				String email = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(5)),"");
				// 省
				String provinceName = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(6)),"");
				
				// 所在城市名称
				String cityName = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(7)),"");
				
				// 所在区名称
				String districtName = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(8)),"");
				
				// 详细地址
				String address = StringUtils.defaultIfBlank(CommonUtil.getCellValue(row.getCell(9)),"");
				
				
				InstitutionImportData  importData=  new InstitutionImportData();
				importData.setRowNum(i+1);
				importData.setInstitutionName(name);	// 会员账号
				importData.setMobile(phone);			// 手机号码
				importData.setEmail(email);				// 电子邮箱
				importData.setImportResult(1);			// 默认为导入成功
				importData.setDescription("导入成功");
				if(StringUtils.isBlank(account)){
					importData.setImportResult(0);
					importData.setDescription("用户名不能为空");
					result.add(importData);
					continue;
				}else{
					Institution institutionDB = institutionDao.getInstitutionByAccount(account);
					if(null != institutionDB){
						importData.setImportResult(0);			
						importData.setDescription("机构已存在");
						result.add(importData);
						continue;
					}
				}
				if(StringUtils.isBlank(phone)){
					continue;
				}else{
					InstitutionCheck institutionCheckDB = institutionCheckDao.getInstitutionCheckByExecutivePhone(phone);
					if(null != institutionCheckDB){
						importData.setImportResult(0);			
						importData.setDescription("手机已经存在");
						result.add(importData);
						continue;
					}
				}
				// 验证
				if(StringUtils.isBlank(email)){
					continue;
				}else{
					InstitutionCheck institutionCheckDB = institutionCheckDao.getInstitutionCheckByEmail(email);
					if(null != institutionCheckDB){
						importData.setImportResult(0);			
						importData.setDescription("邮箱已经存在");
						result.add(importData);
						continue;
					}
				}

				Integer provinceId = null;
				if(StringUtils.isNotBlank(provinceName)){
					if(provinceName.equals("内蒙古自治区")){
						provinceName = "内蒙古";
					}else if(provinceName.equals("澳门特别行政区")){
						provinceName = "澳门";
					}else if(provinceName.equals("西藏自治区")){
						provinceName="西藏";
					}else if(provinceName.equals("广西壮族自治区")){
						provinceName="广西省";
					}else if(provinceName.equals("宁夏回族自治区")){
						provinceName="宁夏";
					}else if(provinceName.equals("香港特别行政区")){
						provinceName="香港";
					}
					CodeProvince codeProvince = codeProvinceDao.getCodeProvinceByName(provinceName);
					if(codeProvince!=null){
						provinceId = codeProvince.getIdx();
					}else{
						importData.setImportResult(0);
						importData.setDescription("没有找到省份:"+provinceName);
						result.add(importData);
						continue;
					}
				}else{
					importData.setImportResult(0);
					importData.setDescription("省不能为空");
					result.add(importData);
					continue;
				}
				Integer cityId = null;
				if(StringUtils.isNotBlank(cityName)){
					CodeCity codeCity = codeCityDao.getCodeCityByName(provinceName, cityName);
					if(codeCity!=null){
						cityId = codeCity.getIdx();
					}else{
						importData.setImportResult(0);			
						importData.setDescription("没有找到城市:"+cityName);
						result.add(importData);
						continue;
					}
				}else{
					importData.setImportResult(0);
					importData.setDescription("市不能为空");
					result.add(importData);
					continue;
				}
				Integer districtId = null;
				if(StringUtils.isNotBlank(districtName)){
					CodeAddress codeAddress=null;
					List<CodeAddress> codeAddressList=codeAddressDao.selProvinceCityDistrict(provinceName, cityName, districtName);
					if(codeAddressList!=null&&codeAddressList.size()>0){
						codeAddress=codeAddressList.get(0);
					}
					if(codeAddress!=null){
						districtId = codeAddress.getIdx();
					}else{
						importData.setImportResult(0);			
						importData.setDescription("没有找到区域:"+districtName);
						result.add(importData);
						continue;
					}
				}else{
					importData.setImportResult(0);
					importData.setDescription("区不能为空");
					result.add(importData);
					continue;
				}

				Institution institution = new Institution();
				// 状态：0-注册完成、1、基本信息已完成、2-资料已完善、3-预约已设定、4-已上传合约、5-已签订合约、6-审核通过、7-审核不通过
				institution.setStatus(0);
				// 启用状态0：启用；1：禁用
				institution.setUsingStatus(0);
				// 机构名称
				institution.setName(name);
				// 机构登录账号
				institution.setAccount(account);
				// 密码
				institution.setPassword(DataUtil.encryptionPw(Constant.DEFAULTPASSWORD));
				institutionDao.add(institution);
				
				Institution institutionDB=institutionDao.getInstitutionByAccountAndPwd(account, DataUtil.encryptionPw(Constant.DEFAULTPASSWORD));
				
				InstitutionCheck institutionCheck = new InstitutionCheck();
				//机构编号
				institutionCheck.setInstitutionNo(institutionDB.getInstitutionNo());
				// 门诊电话
				
				institutionCheck.setLinkTel(tel);
				// 行政负责人
				institutionCheck.setExecutive(linkPerson);
				// 行政负责手机
				institutionCheck.setExecutivePhone(phone);
				// 行政负责邮箱
				institutionCheck.setEmail(email);
				// 省市区
				String provinceCity = "";
				// 省
				institutionCheck.setProvinceName(provinceName);
				if(null != provinceId){
					provinceCity += provinceName.trim();
					institutionCheck.setProvinceId(provinceId.toString());
				}
				// 市
				institutionCheck.setCityName(cityName);
				if(null != cityId){
					provinceCity +="-"+cityName.trim();
					institutionCheck.setCityId(cityId.toString());
				}
				// 区
				if(null != districtId){
					provinceCity +="-"+districtName.trim();
					institutionCheck.setDistrictId(districtId.toString());
				}
				institutionCheck.setDistrictName(districtName);
				// 省市区
				institutionCheck.setProvinceCity(provinceCity);
				institutionCheck.setAddress(address);
				// 审核0-前台启用 1-前台不启用 
				institutionCheck.setStatus(0);
				// 获取坐标
				Map<String,String> map = BaiduMapUtil.geocoding(cityName,districtName+address);
				if(null != map){
					String lng = map.get("lng");
					String lat = map.get("lat");
					institutionCheck.setLng(Double.valueOf(lng));
					institutionCheck.setLat(Double.valueOf(lat));
				}
				institutionCheckDao.add(institutionCheck);
					//机构图片
					String [] doorPhotoArr = new String[]{
						Constant.CLINIC_APPEARANCE,Constant.RECEPTION,Constant.CONSULTING_ROOM,
						Constant.WAITING_AREA,Constant.RADIOLOGY_ROOM,Constant.DENTAL_UNIT,
						Constant.DISINFECTION_ROOM,Constant.QR_CODE
					};
					for (String doorPhoto : doorPhotoArr) {
						SysUploadFile sysUploadFile = new SysUploadFile();
						sysUploadFile.setName(doorPhoto);
						sysUploadFile.setObjectId(institutionCheck.getId());
						sysUploadFile.setObjectType("1");
						sysUploadFile.setType(0);
						// 获取最大的排序值
						Integer sort = sysUploadFileDao.getMaxSortByObjectId(institutionCheck.getId());
						sysUploadFile.setSort(sort+1);
						sysUploadFileDao.add(sysUploadFile);
					}
					//机构证件图片
					String [] doorPhotoArr1 = new String[]{
							Constant.BUSINESS_LICENSE,Constant.MEDICAL_INSTITUTIONS_BUSINESS_LICENSES,
							Constant.ORGANIZATION_CODE_CERTIFICATE,Constant.TAX_REGISTRATION_CERTIFICATE
					};
					for (String doorPhoto : doorPhotoArr1) {
						SysUploadFile sysUploadFile = new SysUploadFile();
						sysUploadFile.setName(doorPhoto);
						sysUploadFile.setObjectId(institutionCheck.getId());
						sysUploadFile.setObjectType("4");
						sysUploadFile.setType(0);
						// 获取最大的排序值
						Integer sort = sysUploadFileDao.getMaxSortByObjectId(institutionCheck.getId());
						sysUploadFile.setSort(sort+1);
						sysUploadFileDao.add(sysUploadFile);
					}
					
					//设备
					//得到设备列表
					List<SysDictItem> sysDictItemList=sysDictItemDao.listSysDictItemByDictId("2");
					for (SysDictItem sysDictItem : sysDictItemList) {
						InstitutionMachine institutionMachine =new InstitutionMachine();
						institutionMachine.setInstitutionId(institutionCheck.getId());
						institutionMachine.setMachineId(sysDictItem.getId());
						institutionMachine.setMachineStatus(0);
						institutionMachineDao.add(institutionMachine);
					}
					institutionService.calcCertification(institution.getId());
				    result.add(importData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String message = "批量导入机构时发生异常:"+e.getMessage();
			throw new RuntimeException(message);
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(out);
			FileUtils.deleteQuietly(destFile);	//删除临时文件
		}
		// 排序





        Collections.sort(result, new Comparator<InstitutionImportData>() {



			public int compare(InstitutionImportData o1, InstitutionImportData o2) {
				return o1.getImportResult().intValue() - o2.getImportResult().intValue();
			}
		});

		return result;
	}*/

	
	
	public void updateName(Institution item) {
		institutionDao.updateName(item);
	}

	public List<Institution> listFastCheck(Integer cityId, Date appointDate) {
		
		return institutionDao.listFastCheck(cityId, appointDate);
	}

	/*@AuthenticationMothod
	public void addBoth(Institution item, InstitutionCheck institutionCheck) {
		institutionDao.add(item);
		Institution institution=institutionDao.getInstitutionByAccountAndPwd(item.getAccount(), item.getPassword());
		// 机构编号
		institutionCheck.setInstitutionNo(institution.getInstitutionNo());
		institutionCheckDao.add(institutionCheck);
		
		InstitutionCheck itemCheck=institutionCheckDao.getInstitutionCheckByInstitutionNo(institution.getInstitutionNo());
		*//** 构建机构图片位置 开始 *//*
		String[] doorPhotoArr = new String[] { Constant.CLINIC_APPEARANCE,
				Constant.RECEPTION, Constant.CONSULTING_ROOM,
				Constant.WAITING_AREA, Constant.RADIOLOGY_ROOM,
				Constant.DENTAL_UNIT, Constant.DISINFECTION_ROOM,
				Constant.QR_CODE, };
		for (String doorPhoto : doorPhotoArr) {
			SysUploadFile sysUploadFile = new SysUploadFile();
			sysUploadFile.setName(doorPhoto);
			sysUploadFile.setObjectId(itemCheck.getId());
			sysUploadFile.setObjectType("1");
			sysUploadFileDao.add(sysUploadFile);
		}
		*//** 构建机构图片位置 结束 *//*

		*//** 构建机构证件图片位置 开始 *//*
		String[] doorPhotoArr1 = new String[] { Constant.BUSINESS_LICENSE,
				Constant.MEDICAL_INSTITUTIONS_BUSINESS_LICENSES,
				Constant.ORGANIZATION_CODE_CERTIFICATE,
				Constant.TAX_REGISTRATION_CERTIFICATE };
		for (String doorPhoto : doorPhotoArr1) {
			SysUploadFile sysUploadFile = new SysUploadFile();
			sysUploadFile.setName(doorPhoto);
			sysUploadFile.setObjectId(itemCheck.getId());
			sysUploadFile.setObjectType("4");
			sysUploadFileDao.add(sysUploadFile);
		}
		*//** 构建机构图片位置 结束 *//*
		
		*//** 构建机构设备 开始*//*
		//得到设备列表
		List<SysDictItem> sysDictItemList=sysDictItemDao.listSysDictItemByDictId("2");
		for (SysDictItem sysDictItem : sysDictItemList) {
			InstitutionMachine institutionMachine =new InstitutionMachine();
			institutionMachine.setInstitutionId(itemCheck.getId());
			institutionMachine.setMachineId(sysDictItem.getId());
			institutionMachine.setMachineStatus(0);
			institutionMachineDao.add(institutionMachine);
		}
		*//** 构建机构设备 结束*//*
	}

	@AuthenticationMothod
	public void updateBoth(Institution item, InstitutionCheck institutionCheck) {
		institutionDao.update(item);
		institutionCheckDao.updateCoord(institutionCheck);
		institutionCheckDao.update(institutionCheck);
	}*/

	public void updateAuthentcationRate(Institution institution) {
			institutionDao.updateAuthentcationRate(institution);
	}

	public void updateTrialById(String[] ids, Integer trial) {
		institutionDao.updateTrialById(ids, trial);

	}

	@Override
	public void updateFinerStatus(Institution item) {
		institutionDao.updateFinerStatus(item);
	}

	public void updateocStatusById(String[] ids, Integer ocStatus) {
		/*for (String id : ids) {
			Institution	institution =institutionDao.getInstitutionById(id);
			InstitutionCheck institutionCheck=institutionCheckDao.getInstitutionCheckByInstitutionNo(institution.getInstitutionNo());
			institutionCheck.setStatus(ocStatus);
			institutionCheckDao.update(institutionCheck);
		}*/
	}

	public void updateAuthentcationStatusById(Integer authentcationStatus,String id) {
		institutionDao.updateAuthentcationStatusById(authentcationStatus, id);
	}

	public void updateBlStatusById(Integer blStatus, String id) {
		institutionDao.updateBlStatusById(blStatus, id);
	}

	public void updateMiblStatusById(Integer miblStatus, String id) {
		institutionDao.updateMiblStatusById(miblStatus, id);
	}

	public List<Institution> listInstitutionByExpertId(String expertId) {
		return institutionDao.listInstitutionByExpertId(expertId);
	}

	/**
	 * 按照距离分页查询
	 * @param pageResult
	 * @param condition
	 * @return
	 */
	public void listDistanceByPage(PageResult<Institution> pageResult, InstitutionCondition condition) {
		/*int rows = institutionDao.listDistanceByPageCount(condition);
		pageResult.setRows(rows);
			RowBounds bounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
			List<Institution> list = institutionDao.listDistanceByPage(bounds, condition);

			for (Institution item : list) {
				InstitutionCheck check = institutionCheckDao.getInstitutionCheckByInstitutionNo(item.getInstitutionNo());
			if(null != check){
				item.setInstitutionCheck(check);
				SysUploadFile firstPhoto = sysUploadFileDao.getSysUploadFileByObjectIdAndObjectTypeAndName(check.getId(), "1",Constant.CLINIC_APPEARANCE);
				item.setFirstPhoto(firstPhoto);
				// 查询机构所参加活动的图标
				List<InstitutionActivity> institutionActivitieList = institutionActivityDao.listInstitutionActivityByInstiutionIdAndStatus(item.getId(), 1);
				if (institutionActivitieList != null) {
					List<Card> activityIconList = new ArrayList<Card>();
					if (!CollectionUtils.isEmpty(institutionActivitieList)) {
						for (InstitutionActivity institutionActivity : institutionActivitieList) {
							Card card = cardDao.getCardById(institutionActivity.getActivityId());
							if (null != card) {
								activityIconList.add(card);
							}
						}
					}
					//活动卡
					item.setActivityIconList(activityIconList);
				}
			}
		}
		
		pageResult.setResult(list);*/
	}

	public Institution calcCertification(String id) {
			/*List<Object> objectList = new ArrayList<Object>();
			// 查询最新机构信息
			Institution institution = institutionDao.getInstitutionById(id);
			// 机构详细信息
			InstitutionCheck institutionCheck = institutionCheckService.getInstitutionCheckByInstitutionNo(institution.getInstitutionNo());
			// 机构预约设置
			InstitutionAppointSet institutionAppointSet = institutionAppointSetService.getInstitutionAppointSetByInstitutionId(id);
			
			objectList.add(institution);
			objectList.add(institutionCheck);
			objectList.add(institutionAppointSet);
			
			// 机构认证有效个数
			Integer authentcationEffectiveCount = 0;
			
			// 遍历以上对象，获取对象中属性包含Authentication注解的字段
			for (Object object : objectList) {
				if(null == object){
					continue;
				}
				List<Field> fieldList = ReflectionUtil.getFieldByAnnotation(object,AuthenticationField.class);
				if(CollectionUtils.isEmpty(fieldList)){
					continue;
				}
				for (Field field : fieldList) {
					// 获取字段的值
					Object objVal = ReflectionUtil.getFieldValue(object, field.getName());
					if(null == objVal){
						continue;
					}
					// 获取字段的Authentication注解
					AuthenticationField authentication = field.getAnnotation(AuthenticationField.class);
					// 如果注解的type属性为NOT_EMPTY,则需要验证是否为空，针对String类型的属性
					if(authentication.rule() == AuthenticationRule.NOT_EMPTY){
						if(StringUtils.isNotBlank(objVal.toString())){
							authentcationEffectiveCount++;
						}
					}else if(authentication.rule() == AuthenticationRule.NOT_NULL){
						if (StringUtils.isNotBlank(objVal.toString())) {
							authentcationEffectiveCount++;
						}

					}
				}
			}
			
			// 检查机构图片是否存在
			for (String institutionPhotoName : institutionPhotoArr) {
				SysUploadFile institutionPhoto = sysUploadFileService.getSysUploadFileByObjectIdAndObjectTypeAndName(institutionCheck.getId(), INSTITUTION_PHOTO, institutionPhotoName);
				if(null != institutionPhoto && StringUtils.isNotBlank(institutionPhoto.getPath())){
					authentcationEffectiveCount++;
				}
			}
			
			// 检查机构设备图片是否存在
		List<SysUploadFile> institutionDeviceList = sysUploadFileService.listSysUploadFileByObjectIdAndObjectType(institutionCheck.getId(), INSTITUTION_DEVICES);
		if(!CollectionUtils.isEmpty(institutionDeviceList)){
			authentcationEffectiveCount++;
		}
			
			// 检查机构优势特点图片是否存在
			List<SysUploadFile> institutionAdvantageList = sysUploadFileService.listSysUploadFileByObjectIdAndObjectType(institutionCheck.getId(), INSTITUTION_ADVANTAGE);
			if(!CollectionUtils.isEmpty(institutionAdvantageList)){
				authentcationEffectiveCount++;
			}
			
			// 检查机构营业执照图片是否存在
			SysUploadFile institutionBusinessLicense = sysUploadFileService.getSysUploadFileByObjectIdAndObjectTypeAndName(institutionCheck.getId(), INSTITUTION_CERTIFICATES, Constant.BUSINESS_LICENSE);
			if(null != institutionBusinessLicense && StringUtils.isNotBlank(institutionBusinessLicense.getPath())){
				authentcationEffectiveCount++;
			}

			// 检查机构医疗机构经营许可证是否存在
			SysUploadFile institutionMedicalInstitutionsBusinessLicenses = sysUploadFileService.getSysUploadFileByObjectIdAndObjectTypeAndName(institutionCheck.getId(), INSTITUTION_CERTIFICATES, Constant.MEDICAL_INSTITUTIONS_BUSINESS_LICENSES);
			if(null != institutionMedicalInstitutionsBusinessLicenses && StringUtils.isNotBlank(institutionMedicalInstitutionsBusinessLicenses.getPath())){
				authentcationEffectiveCount++;
			}
			
			// 检查机构是否存在医生
			List<InstitutionExpert> institutionExpertList = institutionExpertService.listInstitutionExpertByInstitutionId(institution.getId());
			if(!CollectionUtils.isEmpty(institutionExpertList)){
				authentcationEffectiveCount++;
			}
			
			// 检查预约时间设定是否存在
			List<InstitutionAppointArrange> institutionAppointArrangeList = institutionAppointArrangeService.listInstitutionAppointArrangeByInstitutionId(institution.getId());
			if(!CollectionUtils.isEmpty(institutionAppointArrangeList)){
				authentcationEffectiveCount++;
			}
			
			// 检查服务项目是否存在
			List<InstitutionServiceItem> institutionServiceItemList = institutionServiceItemService.listInstitutionServiceItemByInstitutionId(institution.getId());
			if(!CollectionUtils.isEmpty(institutionServiceItemList)){
				authentcationEffectiveCount++;
			}
			
			// 认证率
			Double authentcationRate = CommonUtil.div(authentcationEffectiveCount, AUTHENTCATION_COUNT) * 100;
			authentcationRate = CommonUtil.roundHalfUp(authentcationRate);
			if(authentcationRate==100){
				institution.setStatus(1);
			}else{
				institution.setStatus(0);
			}
			institution.setAuthentcationRate(authentcationRate.intValue());
//xgs by 2015年8月11日10:33:19
		if(institution.getFinerStatus()==0){
			institution.setRecommend(institution.getAuthentcationRate());
		}
//end
			// 更新认证度
			institutionService.updateAuthentcationRate(institution);
			institution = institutionService.getInstitutionByItem(institution);
		    institution.setInstitutionCheck(institutionCheck);*/
		Institution institution=new Institution();
		return  institution;
	}

	public void listInstBypage(PageResult<Institution> pageResult,List<String> item,String name){


		/*Map<String,Object> map=new HashMap<String, Object>();
		map.put("name",name);
		map.put("item",item);
		RowBounds rowBounds = new RowBounds(pageResult.getCurrentPageIndex(),pageResult.getPageSize());
		List<Institution> list=institutionDao.listInstBypage(rowBounds,map);
		int rows =institutionDao.listInstBypageCount(map);
		pageResult.setRows(rows);
		int all=rows/pageResult.getPageSize()+1;
		pageResult.setAllPages(all);

		for (Institution inst : list) {
			InstitutionCheck check = institutionCheckDao.getInstitutionCheckByInstitutionNo(inst.getInstitutionNo());
			if(null != check){
				inst.setInstitutionCheck(check);
				SysUploadFile firstPhoto = sysUploadFileDao.getSysUploadFileByObjectIdAndObjectTypeAndName(check.getId(), "1",Constant.CLINIC_APPEARANCE);
				inst.setFirstPhoto(firstPhoto);

				List<InstitutionActivity> institutionActivitieList = institutionActivityDao.listInstitutionActivityByInstiutionIdAndStatus(inst.getId(), 1);
				if (institutionActivitieList != null) {
					List<Card> activityIconList = new ArrayList<Card>();
					if (!CollectionUtils.isEmpty(institutionActivitieList)) {
						for (InstitutionActivity institutionActivity : institutionActivitieList) {
							Card card = cardDao.getCardById(institutionActivity.getActivityId());
							if (null != card) {
								activityIconList.add(card);
							}
						}
					}
					//活动卡
					inst.setActivityIconList(activityIconList);
				}
			}
		}

		pageResult.setResult(list);*/
	}

	public List<Institution> listInstNotNo(List<String> item){
		/*List<Institution> list=institutionDao.listInstNotNo(item);
		for (Institution inst : list) {
			InstitutionCheck check = institutionCheckDao.getInstitutionCheckByInstitutionNo(inst.getInstitutionNo());
			if(null != check){
				inst.setInstitutionCheck(check);
				SysUploadFile firstPhoto = sysUploadFileDao.getSysUploadFileByObjectIdAndObjectTypeAndName(check.getId(), "1",Constant.CLINIC_APPEARANCE);
				inst.setFirstPhoto(firstPhoto);
			}
			int count =collectDao.listCollectCount(inst.getId());
			inst.setCollectCount(count);
		}
        return list;*/
		List<Institution> list=institutionDao.listInstNotNo(item);
		return list;
	}

	@Override
	public void listMobileByDistance(PageResult<Institution> pageResult, InstitutionCondition condition) {
		/*int count = institutionDao.listByConditionCountNum(condition);
		pageResult.setRows(count);
		RowBounds bounds = new RowBounds(pageResult.getCurrentPageIndex(), pageResult.getPageSize());
		List<Institution> list = institutionDao.listByCondition(bounds,condition);
		for (Institution item : list) {
			InstitutionCheck check = institutionCheckDao.getInstitutionCheckByInstitutionNo(item.getInstitutionNo());
			if(null != check){
				item.setInstitutionCheck(check);
				if(null == check.getLat() && null == check.getLng()){
					//得到经纬度
					try{
						Map<String,String> map = BaiduMapUtil.geocoding(check.getCityName(), check.getDistrictName()+check.getAddress());
						if(null != map){
							double lng = Double.parseDouble(map.get("lng").toString());
							double lat = Double.parseDouble(map.get("lat").toString());
							check.setLng(lng);
							check.setLat(lat);
							//更新
							institutionCheckDao.updateCoord(check);
						}
					}catch (Exception e){
						logger.error("获取地址出错",e);
					}

				}
				if(null != condition.getLat() && null != condition.getLng()){
					if(!StringUtils.isBlank(check.getLat()+"")&&!StringUtils.isBlank(check.getLng()+"")) {
						double distance = BaiduMapUtil.getDistance(condition.getLat(), condition.getLng(), check.getLat(), check.getLng());
						item.setDistance(distance);
					}

				}
			}
		}
		pageResult.setResult(list);*/
	}

}

