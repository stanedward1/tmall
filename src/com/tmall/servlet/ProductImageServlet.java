package com.tmall.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tmall.bean.Product;
import com.tmall.bean.ProductImage;
import com.tmall.dao.ProductImageDAO;
import com.tmall.util.ImageUtil;
import com.tmall.util.Page;

public class ProductImageServlet extends BaseBackServlet{
	
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		//�ϴ��ļ���������
		InputStream is = null;
		//�ύ�ļ��Ĳ���
		Map<String, String> params = new HashMap<>();
		
		//�����ϴ�
		is = parseUpload(request, params);
		
		//�����ϴ��Ĳ������ɶ�Ӧ��ProdctImage����
		String type = params.get("type");
		int pid = Integer.parseInt(params.get("pid"));
		Product p = productDAO.get(pid);
		
		ProductImage pi = new ProductImage();
		pi.setType(type);
		pi.setProduct(p);
		productImageDAO.add(pi);
		
		//�����ļ�
		String filename = pi.getId() + ".jpg";
		String imageFolder;
		String imageFolder_small = null;
		String imageFolder_middle = null;
		
		if (productImageDAO.type_single.equals(pi.getType())) {
			imageFolder = request.getSession().getServletContext().getRealPath("img/productSingle");
			imageFolder_small = request.getSession().getServletContext().getRealPath("img/productSingle_small");
			imageFolder_middle = request.getSession().getServletContext().getRealPath("img/productSingle_middle");
			
		}
		else {
			imageFolder = request.getSession().getServletContext().getRealPath("img/productDetail");
		}

		File f = new File(imageFolder, filename);
		f.getParentFile().mkdirs();
		
		//�����ļ�
		try {
			if (null!=is && 0!=is.available()) {
				try (FileOutputStream fos = new FileOutputStream(f)) {
					byte b[] = new byte[1024 * 1024];
					int length = 0;
					while(-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					
					//ͨ�����´���,���ļ�����ΪJPG��ʽ
					BufferedImage img = ImageUtil.change2jpg(f); 
					ImageIO.write(img, "jpg", f);
					
					if(ProductImageDAO.type_single.equals(pi.getType())) {
						File f_small = new File(imageFolder_small, filename);
						File f_middle = new File(imageFolder_middle, filename);
						
						ImageUtil.resizeImage(f, 56, 56, f_small);
						ImageUtil.resizeImage(f, 217, 190, f_middle);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "@admin_productImage_list?pid=" + p.getId();
	}
	
	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductImage pi = productImageDAO.get(id);
        productImageDAO.delete(id);
         
        if(ProductImageDAO.type_single.equals(pi.getType())){
            String imageFolder_single= request.getSession().getServletContext().getRealPath("img/productSingle");
            String imageFolder_small= request.getSession().getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle= request.getSession().getServletContext().getRealPath("img/productSingle_middle");
             
            File f_single =new File(imageFolder_single,pi.getId()+".jpg");
            f_single.delete();
            File f_small =new File(imageFolder_small,pi.getId()+".jpg");
            f_small.delete();
            File f_middle =new File(imageFolder_middle,pi.getId()+".jpg");
            f_middle.delete();
             
        }
 
        else{
            String imageFolder_detail= request.getSession().getServletContext().getRealPath("img/productDetail");
            File f_detail =new File(imageFolder_detail,pi.getId()+".jpg");
            f_detail.delete();         
        }
        return "@admin_productImage_list?pid="+pi.getProduct().getId();
    }
 
    @Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;       
    }
 
    @Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;   
    }
 
    @Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product p =productDAO.get(pid);
        List<ProductImage> pisSingle = productImageDAO.list(p, ProductImageDAO.type_single);
        List<ProductImage> pisDetail = productImageDAO.list(p, ProductImageDAO.type_detail);
         
        request.setAttribute("p", p);
        request.setAttribute("pisSingle", pisSingle);
        request.setAttribute("pisDetail", pisDetail);
         
        return "admin/listProductImage.jsp";
    }
	
}
