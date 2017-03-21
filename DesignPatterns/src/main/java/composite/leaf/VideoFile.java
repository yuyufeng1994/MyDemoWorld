package composite.leaf;

import composite.comonpent.AbstractFile;

/**
 * 音频类型
 * @author Yu Yufeng
 *
 */
public class VideoFile implements AbstractFile {
	private String fileName;

	public VideoFile(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void add(AbstractFile f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(AbstractFile f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println("|" + fileName);
	}

}
