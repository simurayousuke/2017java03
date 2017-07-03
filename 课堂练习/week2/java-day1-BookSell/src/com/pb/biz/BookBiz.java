package com.pb.biz;
import com.pb.entity.EX;
import com.pb.entity.Book;
import com.pb.entity.EXFactory;
public class BookBiz {
   public static Book[] books=new Book[30];
   /**
	 * ��ʼ�������Ϣ
	 */
	public static void makeData() {
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book();

		book1.setId(10001);
		book1.setName("����");
		book1.setAuthor("���°Գ�");
		book1.setPub_date("2008-7-1");
		book1.setPrice(27.80);
		book1.setStore(87);

		book2.setId(10002);
		book2.setName("ħ��1");
		book2.setAuthor("Ī��˹");
		book2.setPub_date("2005-3-14");
		book2.setPrice(54.00);
		book2.setStore(13);

		book3.setId(10003);
		book3.setName("��������1");
		book3.setAuthor("����");
		book3.setPub_date("2003-2-14");
		book3.setPrice(43.50);
		book3.setStore(99);

		book4.setId(10004);
		book4.setName("ʱ�����");
		book4.setAuthor("����");
		book4.setPub_date("1965-3-3");
		book4.setPrice(21.30);
		book4.setStore(75);

		book5.setId(10005);
		book5.setName("�������");
		book5.setAuthor("����");
		book5.setPub_date("2003-12-23");
		book5.setPrice(87.30);
		book5.setStore(14);

		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		books[3] = book4;
		books[4] = book5;
	}
	 
	public Book findBookById(int id){
		for(int i=0;i<books.length;i++){
			if(books[i]==null){
				return null;
			}
			if(books[i].getId()==id){
				return books[i];
			}
		}
	  return null;
	}
	public void inBook(int bookid,int num){
		Book book=findBookById(bookid);
		if(book==null){
			System.out.println("û�д˱�ͼ�飬����ѡ��");
			return;
		}else{
			for(int i=0;i<books.length;i++){
				if(bookid==books[i].getId()){
					books[i].setStore(books[i].getStore()+num);
					break;
				}
			}
		}
	}
	
	public void outBook(int bookid,int num){
		Book book=findBookById(bookid);
		if(book==null){
			System.out.println("���鲻���ڣ���ȷ�ϣ�");
			return;
		}else{
			for (int i = 0; i < books.length; i++) {// �������
				if (bookid == books[i].getId()) {//����ҵ�������ͼ��
					if(books[i].getStore()<num){//�жϿ����
						System.out.println("��治�㣬��ȷ�ϣ�");
						return;
					}else{
						books[i].setStore(books[i].getStore() - num);//���⣨���ٿ��������
						break;
					}
				}
			}
		}
	}
	
	/**
	 * ��ѯͼ��
	 */
	public void query() {
		System.out.println("���\t\t����\t\t����\t\t��������\t\t�۸�\t���");
		for (int i = 0; i < books.length; i++) {//�������
			Book temp = books[i];
			if (temp == null)//�ж�����Ƿ�����
				break;
			else {//��ʾͼ����Ϣ
				int id = temp.getId();
				String name = temp.getName();
				String author = temp.getAuthor();
				String pub_date = temp.getPub_date();
				double price = temp.getPrice();
				int store = temp.getStore();
				System.out.println(id + "\t\t" + name + "\t\t" + author
						+ "\t\t" + pub_date + "\t" + price + "\t" + store);
			}
		}
	}
	/**
	 * ����ͼ��
	 */
	public void saveBook(Book book){
		for (int i = 0; i < books.length; i++) {// �������
			if (books[i] == null) {//�ҵ���ܵĿ�λ��
				int newId=books[i-1].getId()+1;//��������
				book.setId(newId);
				books[i]=book;//�洢����
				break;
			} 
		}
	}
	

	/**
	 * ����ͼ��
	 * @return
	 */
	public Book buyBook(int bookId,int num){
		Book book=findBookById(bookId);//���ҵ�ͼ��
		if(book==null){//���û�д��飬����null
			System.out.println("���鲻���ڣ���ȷ�ϣ�");
			return null;
		}else{
			for (int i = 0; i < books.length; i++) {// �������
				if (bookId == books[i].getId()) {//����ҵ�������ͼ��
					if(books[i].getStore()<num){//�жϿ����
						System.out.println("��治�㣬��ȷ�ϣ�");
						return null;
					}else{
						books[i].setNum(num);//���ù�������
						return books[i];
					}
				}
			}
		}
		return null;
	}
	
	public EX buyEX(int excode){
		return EXFactory.create(excode);
	}
	
	/**
	 * ����
	 */
	public void checkout(Book book){
		book.setStore(book.getStore() - book.getNum());//���ٿ������
		double price = book.cost();// ����۸�
		System.out.println("�ܼ۸�Ϊ��" + price+"\n");	
	}
	
}
