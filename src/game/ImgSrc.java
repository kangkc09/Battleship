package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgSrc
{
	private BufferedImage img = null;
	public static final int CW_0DEG=0;
	public static final int CW_90DEG=1;
	public static final int CW_180DEG=2;
	public static final int CW_270DEG=3;
	public BufferedImage srcPlayer1Win()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/player1win.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcPlayer2Win()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/player2win.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcBoom()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/boom.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcMiss()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/miss.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcX()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/x.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcExplode()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/explode.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcUpArrow()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/uparrow.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcStartPage()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/backgroundwithbutton.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcMap()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/map.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcBackground()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/background.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcShowButton()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/showbutton.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcHideButton()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/hidebutton.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcStartButton()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/startbutton.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcPatrolBoat(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/patrolboat_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/patrolboat_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/patrolboat_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/patrolboat_270deg.png";
			break;
		default:
			System.out.println("PatrolBoat error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcDestroyer(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/destroyer_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/destroyer_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/destroyer_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/destroyer_270deg.png";
			break;
		default:
			System.out.println("Destroyer error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcCruiser(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/cruiser_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/cruiser_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/cruiser_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/cruiser_270deg.png";
			break;
		default:
			System.out.println("Cruiser error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcBattleship(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/battleship_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/battleship_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/battleship_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/battleship_270deg.png";
			break;
		default:
			System.out.println("Battleship error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcSubmarine(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/submarine_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/submarine_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/submarine_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/submarine_270deg.png";
			break;
		default:
			System.out.println("Submarine error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
	public BufferedImage srcAircraftCarrier(int orientation)
	{
		String source = null;
		switch (orientation)
		{
		case CW_0DEG:
			source = "src/resource/aircraftcarrier_0deg.png";
			break;
		case CW_90DEG:
			source = "src/resource/aircraftcarrier_90deg.png";
			break;
		case CW_180DEG:
			source = "src/resource/aircraftcarrier_180deg.png";
			break;
		case CW_270DEG:
			source = "src/resource/aircraftcarrier_270deg.png";
			break;
		default:
			System.out.println("AircraftCarrier error");
			System.exit(0);
			break;
		}
		try
		{
			img = ImageIO.read(new File(source));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}

	public BufferedImage srcKing()
	{
		try
		{
			img = ImageIO.read(new File("src/resource/king.png"));
		} catch (IOException e)
		{
			System.out.println(e);
		}
		return img;
	}
}
