package com.kh.sc.notice.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.notice.model.service.noticeService;
import com.kh.sc.notice.model.vo.notice;
import com.kh.sc.common.util.Utils;

@Controller
public class noticeController {

	@Autowired
	noticeService noticeService;

	@RequestMapping("/notice/noticeList.do")
	public String selectNoticeList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
			Model model) {

		// 한 페이지당 보여줄 게시글 수
		int numPerPage = 10;

		// 페이지 처리된 리스트 가져오기
		List<Map<String, String>> list = noticeService.selectList(cPage, numPerPage);

		// 전체 게시글 수 가져오기
		int totalContents = noticeService.selectTotalContents();

		// 페이지 계산 HTML을 추가하기
		String pageBar = Utils.getPageBar(totalContents, cPage, numPerPage, "noticeList.do");

		System.out.println(pageBar);

		model.addAttribute("list", list).addAttribute("totalContents", totalContents)
				.addAttribute("numPerPage", numPerPage).addAttribute("pageBar", pageBar);

		return "board/boardList";
	}

	@RequestMapping("/notice/noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";
	}

	@RequestMapping("/notice/noticeFormEnd.do")
	public String insertBoard(notice notice, Model model)
			/*@RequestParam(value = "upFile", required = false) MultipartFile[] upFiles, HttpServletRequest request)
			throws Exception*/ {

		/*
		 * // 1. 저장할 폴더 설정 String savePath =
		 * request.getSession().getServletContext().getRealPath("/resources/upload");
		 * 
		 * // 2. DB에 전달할 파일 정보를 담을 list 준비하기 List<Attachment> list = new ArrayList();
		 * 
		 * // 3. 만약 저장할 폴더가 없다면 직접 만들기 File dir = new File(savePath); if (dir.exists()
		 * == false) dir.mkdirs();
		 */

		/********** Multipart 파일 업로드 시작 **********/
		/*
		 * 
		 * for(MultipartFile f : upFiles) { if( !f.isEmpty() ) { // 파일 이름 재생성해서 저장하기
		 * String originalFileName = f.getOriginalFilename(); String ext =
		 * originalFileName.substring(originalFileName.lastIndexOf(".") + 1); //
		 * sample.jpg --> .jpg
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		 * 
		 * int rndNum = (int)(Math.random()*1000);
		 * 
		 * String renamedFileName = sdf.format(new
		 * Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext; // -->
		 * 20191230_154500_1.jpg
		 * 
		 * try {
		 * 
		 * f.transferTo(new File(savePath + "/" + renamedFileName));
		 * 
		 * } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 * 
		 * // 저장된 파일 정보를 list에 담기
		 * 
		 * Attachment att = new Attachment(); att.setOriginalFileName(originalFileName);
		 * att.setRenamedFileName(renamedFileName);
		 * 
		 * list.add(att); } }
		 *//********** Multipart 파일 업로드 끝 **********/

		/*
		 * int result = 0;
		 * 
		 * try { result = noticeService.insertNotice(notice, list); } catch (Exception
		 * e) { if (list.size() > 0) { for (Attachment a : list) { File delFile = new
		 * File(savePath + "/" + a.getRenamedFileName());
		 * 
		 * boolean isDelete = delFile.delete();
		 * 
		 * System.out.println("파일 삭제 여부 확인 : " + isDelete); } }
		 * 
		 * throw e; // 스프링이 처리할 꺼라서 그냥 던져도 됩니다. }
		 */
		int result = 0;
		
		String msg = "";
		String loc = "/notice/noticeList.do";

		if (result > 0) {
			msg = "게시글 추가 성공!";
		} else {
			msg = "게시글 추가 실패!";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);

		return "common/msg";
	}

	@RequestMapping("/notice/noticeView.do")
	public String selectOneBoard(@RequestParam("no") int nNo, Model model) {

		notice n = noticeService.selectOne(nNo);

		/* List<Attachment> list = noticeService.selectAttachment(nNo); */

		model.addAttribute("notice", n);
		/* .addAttribute("attachmentList", list) */
	
		return "notice/noticeView";
	}

	/*
	 * @RequestMapping("/board/fileDownload.do") public void
	 * fileDownload(@RequestParam String oName, @RequestParam String rName,
	 * HttpServletRequest request, HttpServletResponse response) { // 파일저장디렉토리
	 * String saveDirectory =
	 * request.getSession().getServletContext().getRealPath("/resources/upload");
	 * 
	 * BufferedInputStream bis = null; ServletOutputStream sos = null;
	 * 
	 * try { sos = response.getOutputStream(); File savedFile = new
	 * File(saveDirectory + "/" + rName);
	 * response.setContentType("application/octet-stream; charset=utf-8");
	 * 
	 * // 한글 파일명 처리 : 브라우져에 따른 인코딩분기 String resFilename = ""; boolean isMSIE =
	 * request.getHeader("user-agent").indexOf("MSIE") != -1 ||
	 * request.getHeader("user-agent").indexOf("Trident") != -1;
	 * System.out.println("isMSIE=" + isMSIE); if (isMSIE) { // ie는 utf-8인코딩을 명시적으로
	 * 해줌. 공백을 의미하는 +를 %20로 치환. resFilename = URLEncoder.encode(oName, "UTF-8");
	 * System.out.println("ie : " + resFilename);// ie :
	 * %EC%B7%A8+%EC%97%85+%ED%8A%B9+%EA%B0%95.txt
	 * 
	 * resFilename = resFilename.replaceAll("\\+", "%20");
	 * System.out.println("ie : " + resFilename);// ie :
	 * %EC%B7%A8%20%EC%97%85%20%ED%8A%B9%20%EA%B0%95.txt } else { // ? resFilename =
	 * new String(oName.getBytes("UTF-8"), "ISO-8859-1");
	 * System.out.println("not ie : " + resFilename);
	 * 
	 * } response.addHeader("Content-Disposition", "attachment; filename=\"" +
	 * resFilename + "\"");
	 * 
	 * // 파일크기지정 response.setContentLength((int) savedFile.length());
	 * 
	 * FileInputStream fis = new FileInputStream(savedFile); bis = new
	 * BufferedInputStream(fis); int read = 0;
	 * 
	 * while ((read = bis.read()) != -1) { sos.write(read); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * 
	 * try { sos.close(); bis.close(); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * }
	 */
	@RequestMapping("/board/boardUpdateView.do")
	public String boardUpdateView(@RequestParam int nNo, Model model) {

		model.addAttribute("notice", noticeService.selectOne(nNo));
		/* .addAttribute("attachmentList",noticeService.selectAttachment(nNo)) */

		return "board/boardUpdateView";
	}

	@RequestMapping("/board/boardUpdate.do")
	public String boardUpdate(notice notice, Model model,
			@RequestParam(value = "upFile", required = false) MultipartFile[] upFiles, HttpServletRequest request) {

		int nNo = notice.getnNo();

		// 원본 게시글 수정 부분
		notice originBoard = noticeService.selectOne(nNo);
		originBoard.setnTitle(notice.getnTitle());
		originBoard.setnContent(notice.getnContent());

		/*// 정상적인 파일 추가 과정
		// 원본 파일 이름 가져오기
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

		int rndNum = (int) (Math.random() * 1000);

		// 서버에서 관리할 파일이름 생성
		String renamedFileName = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum + "." + ext;

		// 실제 저장할 파일 명을 변경된 파일명으로 만들기
		try {

			f.transferTo(new File(savePath + "/" + renamedFileName));

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		att.setOriginalFileName(originalFileName);
		att.setRenamedFileName(renamedFileName);

		list.set(idx, att);

		idx++;
	}
*/
	int result = noticeService.updateNotice(originBoard);

	String msg = "";
	String loc = "/notice/noticeList.do";

	if(result>0)
	{
		msg = "게시글 수정 성공!";
	}else
	{
		msg = "게시글 수정 실패!";
	}

	model.addAttribute("msg",msg).addAttribute("loc",loc);

	return"common/msg";
	}

	@RequestMapping("/notice/noticeDelete.do")
		public String noticeDelete(int nNo, Model model, HttpSession session) {
			
		/*
		 * // 게시글 삭제 시 게시글에 담긴 첨부파일도 삭제해야 한다. String savePath =
		 * session.getServletContext().getRealPath("/resources/upload");
		 * 
		 * List<Attachment> list = boardService.selectAttachment(nNo);
		 * 
		 * for(Attachment a : list) { new File(savePath + "/" +
		 * a.getRenamedFileName()).delete(); }
		 */
			
			int result = noticeService.deleteNotice(nNo);
			
			String msg = "";
			String loc = "/notice/noticeList.do";
			
			if(result > 0) {
				msg = "개시글 삭제 성공!";
			
			} else {
				msg = "게시글 삭제 실패!";
			}
			
			model.addAttribute("msg", msg)
				 .addAttribute("loc", loc);
			
			
			return "common/msg";
		}

}


