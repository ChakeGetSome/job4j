public void bubbleSorter()
{     
    for (int out = elems - 1; out >= 1; out--)
	{ 
        for (int in = 0; in < out; in++)
		{       
            if(a[in] > a[in + 1])               
                toSwap(in, in + 1);             
        }
    }
}