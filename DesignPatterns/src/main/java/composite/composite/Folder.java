package composite.composite;

import composite.comonpent.AbstractFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹类型
 * @author Yu Yufeng
 *
 */
public class Folder implements AbstractFile {
	private String fileName;
	List<AbstractFile> list = new ArrayList<>();

	public Folder(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void add(AbstractFile f) {
		list.add(f);
	}

	@Override
	public void remove(AbstractFile f) {
		list.remove(f);
	}

	@Override
	public void display(int depth) {
		/**
		 * 为了显示层次效果所以增加了depth，递归显示层级
		 */
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println("|" + fileName);

		for (AbstractFile f : list) {
			f.display(depth + 2);
		}
	}

}
